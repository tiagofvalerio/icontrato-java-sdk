package br.com.idtrust.sdk.icontrato;

import java.io.Serializable;

import javax.ws.rs.core.Response;

import br.com.idtrust.sdk.icontrato.exception.SDKException;
import br.com.idtrust.sdk.icontrato.model.DocumentPackage;
import br.com.idtrust.sdk.icontrato.model.assembler.DocumentAssembler;
import br.com.idtrust.sdk.icontrato.model.assembler.WorkflowAssembler;
import br.com.idtrust.sdk.icontrato.ws.client.RestClient;
import br.com.idtrust.sdk.icontrato.ws.client.dto.DocumentDTO;
import br.com.idtrust.sdk.icontrato.ws.client.dto.WorkflowDTO;
import br.com.idtrust.sdk.icontrato.ws.client.response.DocumentUploadResponse;
import br.com.idtrust.sdk.icontrato.ws.client.response.LoginResponse;

public class IContratoService implements Service, Serializable {

    private static final long serialVersionUID = -3080982999790284615L;

    private RestClient restClient = new RestClient();

    private LoginResponse loginResponse;

    private DocumentUploadResponse documentUploadResponse;

    @Override
    public void SendDocument(DocumentPackage documentPackage)
            throws SDKException {
        System.out.println(
                "Iniciando processo de envio de documento pelo SDK Java.");

        validateDocumentPackage(documentPackage);

        authenticate(documentPackage.getUserName(),
                documentPackage.getPassword());

        DocumentDTO documentDTO = new DocumentAssembler()
                .assembly(documentPackage.getDocument());

        sendDocument(documentDTO);

        WorkflowDTO workflowDTO = new WorkflowAssembler()
                .assembly(documentPackage.getSteps());
        sendWorkflow(workflowDTO);

    }

    private void validateDocumentPackage(DocumentPackage documentPackage)
            throws SDKException {

        System.out.println("Iniciando validação de DocumentPackage");

        if (documentPackage.getUserName().isEmpty()
                || documentPackage.getPassword().isEmpty()) {
            throw new SDKException(
                    "ERRO: Username ou password não informados.");
        }

        if (documentPackage.getDocument() == null
                || documentPackage.getDocument().getDocumentStream() == null) {
            throw new SDKException("ERRO: Documento não informado.");
        }

        if (documentPackage.getSteps().isEmpty()) {
            throw new SDKException("ERRO: Partes não foram informadas.");
        }

        System.out.println("Validação efetuada com sucesso");
    }

    private void authenticate(String username, String password)
            throws SDKException {
        System.out.println("Efetuando autenticação...");

        Response response = restClient.authenticate(username, password);

        if (Response.Status.OK.getStatusCode() != response.getStatus()) {
            throw new SDKException("Login não autorizado");
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
            throw new SDKException("Erro ao enviar documento para iContrato.");
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
            throw new SDKException("Erro ao enviar workflow para iContrato.");
        }

        System.out.println("Workflow enviado com sucesso.");
    }

}
