package br.com.idtrust.sdk.icontrato.ws.client;

import java.io.Serializable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.idtrust.sdk.icontrato.ws.client.dto.DocumentDTO;
import br.com.idtrust.sdk.icontrato.ws.client.dto.WorkflowDTO;

public class RestClient implements Serializable {

    private static final long serialVersionUID = 8213651756093586350L;

    private static final String URL_LOGIN = "https://icontrato.idtrust.com.br:8443/icontrato/auth/login/form";

    private static final String URL_DOCUMENTS = "https://icontrato.idtrust.com.br:8444/icontrato/v1/documents";

    private Client client = ClientBuilder.newClient();

    private WebTarget target = null;

    public Response authenticate(String username, String password) {
        target = client.target(URL_LOGIN);

        Form form = new Form().param("username", username).param("password",
                password);

        return target.request().post(Entity.form(form));
    }

    public Response sendDocument(DocumentDTO documentDTO, String token) {
        target = client.target(URL_DOCUMENTS);

        return target.request().header("Authorization", "Token " + token).post(
                Entity.entity(documentDTO, MediaType.APPLICATION_JSON),
                Response.class);

    }

    public Response sendWorkflow(WorkflowDTO workflowDTO, String token,
            String documentID) {
        target = client.target(URL_DOCUMENTS).path("{documentID}/workflow");

        return target.resolveTemplate("documentID", documentID).request()
                .header("Authorization", "Token " + token)
                .post(Entity.entity(workflowDTO, MediaType.APPLICATION_JSON),
                        Response.class);
    }

}