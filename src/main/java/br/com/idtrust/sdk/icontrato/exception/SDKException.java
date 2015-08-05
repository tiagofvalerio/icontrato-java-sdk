package br.com.idtrust.sdk.icontrato.exception;

public class SDKException extends Exception {

    private static final long serialVersionUID = 7486478442755088844L;

    public SDKException() {
    }

    public SDKException(String message) {
        super(message);
    }

    public SDKException(Throwable cause) {
        super(cause);
    }

    public SDKException(String message, Throwable cause) {
        super(message, cause);
    }

}
