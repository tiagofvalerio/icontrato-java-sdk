package br.com.idtrust.sdk.icontrato.ws.client.response;

import java.io.Serializable;

public class DocumentUploadResponse implements Serializable {

    private static final long serialVersionUID = -8758964603352582697L;

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
