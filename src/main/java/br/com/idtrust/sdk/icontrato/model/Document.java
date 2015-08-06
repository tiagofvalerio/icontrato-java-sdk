package br.com.idtrust.sdk.icontrato.model;

import java.io.InputStream;
import java.io.Serializable;

public class Document implements Serializable {

    private static final long serialVersionUID = 5373957751496934128L;

    private String fileName = "";

    private InputStream documentStream = null;

    public Document() {
    }

    public Document(String fileName,
            InputStream documentStream) {
        this();
        this.fileName = fileName;
        this.documentStream = documentStream;
    }

    public String getFileName() {
        return fileName;
    }

    public InputStream getDocumentStream() {
        return this.documentStream;
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