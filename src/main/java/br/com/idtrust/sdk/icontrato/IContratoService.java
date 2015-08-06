package br.com.idtrust.sdk.icontrato;

import java.io.Serializable;

import javax.ws.rs.core.Response;

import br.com.idtrust.sdk.icontrato.exception.SDKException;
import br.com.idtrust.sdk.icontrato.model.DocumentBuilder;
import br.com.idtrust.sdk.icontrato.model.assembler.DocumentAssembler;
import br.com.idtrust.sdk.icontrato.model.assembler.WorkflowAssembler;
import br.com.idtrust.sdk.icontrato.ws.client.RestClient;
import br.com.idtrust.sdk.icontrato.ws.client.dto.DocumentDTO;
import br.com.idtrust.sdk.icontrato.ws.client.dto.WorkflowDTO;
import br.com.idtrust.sdk.icontrato.ws.client.response.DocumentUploadResponse;
import br.com.idtrust.sdk.icontrato.ws.client.response.LoginResponse;

public class IContratoService implements Service, Serializable {

    private static final long serialVersionUID = -3080982999790284615L;

    private String username;

    private String password;

    private RestClient restClient = new RestClient();

    private LoginResponse loginResponse;

    private DocumentUploadResponse documentUploadResponse;

    public IContratoService(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public void SendDocument(DocumentBuilder documentBuilder)
            throws SDKException {
        System.out.println(
                "Iniciando processo de envio de documento pelo SDK Java.");

        validateDocumentPackage(documentBuilder);

        authenticate(username, password);

        DocumentDTO documentDTO = new DocumentAssembler()
                .assembly(documentBuilder.getDocument());

        sendDocument(documentDTO);

        WorkflowDTO workflowDTO = new WorkflowAssembler()
                .assembly(documentBuilder.getSteps());
        sendWorkflow(workflowDTO);

    }

    private void validateDocumentPackage(DocumentBuilder documentBuilder)
            throws SDKException {

        System.out.println("Iniciando validação de documentBuilder");

        if (documentBuilder.getDocument() == null
                || documentBuilder.getDocument().getDocumentStream() == null) {
            throw new SDKException("ERRO: Documento não informado.");
        }

        if (documentBuilder.getSteps().isEmpty()) {
            throw new SDKException("ERRO: Partes não foram informadas.");
        }

        System.out.println("Validação efetuada com sucesso");
    }

    private void authenticate(String username, String password)
            throws SDKException {

        System.out.println("Efetuando autenticação...");

        Response response = restClient.authenticate(username, password);

        if (Response.Status.OK.getStatusCode() != response.getStatus()) {
            throw new SDKException("Login não autorizado: "
                    + response.readEntity(String.class));
        }

        loginResponse = response.readEntity(LoginResponse.class);

        if (loginResponse.getAuthctoken().isEmpty()) {
            throw new SDKException("Token de autorização não retornado.");
        }
    }

    private void sendDocument(DocumentDTO documentDTO) throws SDKException {
        System.out.println("Enviando documento para iContrato...");

        Response response = restClient.sendDocument(documentDTO,
                loginResponse.getAuthctoken());

        if (Response.Status.OK.getStatusCode() != response.getStatus()) {
            throw new SDKException("Erro ao enviar documento para iContrato: "
                    + response.readEntity(String.class));

        }

        documentUploadResponse = response
                .readEntity(DocumentUploadResponse.class);

        if (documentUploadResponse.getId().isEmpty()) {
            throw new SDKException("Id do documento não retornado.");
        }
    }

    private void sendWorkflow(WorkflowDTO workflowDTO) throws SDKException {
        System.out.println("Enviando workflow para iContrato...");

        Response response = restClient.sendWorkflow(workflowDTO,
                loginResponse.getAuthctoken(), documentUploadResponse.getId());

        if (Response.Status.OK.getStatusCode() != response.getStatus()) {
            throw new SDKException("Erro ao enviar workflow para iContrato: "
                    + response.readEntity(String.class));
        }

        System.out.println("Workflow enviado com sucesso.");
    }

}
