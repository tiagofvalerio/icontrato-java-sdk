package br.com.idtrust.sdk.icontrato.model;

import java.io.InputStream;
import java.io.Serializable;

public class Document implements Serializable {

    private static final long serialVersionUID = 5373957751496934128L;

    private String emailOwner = "";

    private String fileName = "";

    private InputStream documentStream = null;

    public Document() {
    }

    public Document(String emailOwner, String fileName,
            InputStream documentStream) {
        this();
        this.emailOwner = emailOwner;
        this.fileName = fileName;
        this.documentStream = documentStream;
    }

    public String getEmailOwner() {
        return emailOwner;
    }

    public String getFileName() {
        return fileName;
    }

    public InputStream getDocumentStream() {
        return this.documentStream;
    }

    public Document withEmailOwner(String emailOwner) {
        this.emailOwner = emailOwner;
        return this;
    }

    public Document withfileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public Document withDocumentStream(InputStream documentStream) {
        this.documentStream = documentStream;
        return this;
    }

}