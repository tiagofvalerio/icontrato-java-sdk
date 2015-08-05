package br.com.idtrust.sdk.icontrato.ws.client.response;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 5903212172410519931L;

    private String authctoken;

    public String getAuthctoken() {
        return authctoken;
    }

    public void setAuthctoken(String authctoken) {
        this.authctoken = authctoken;
    }

    @Override
    public String toString() {
        return "LoginResponse [authctoken=" + authctoken + "]";
    }

}
