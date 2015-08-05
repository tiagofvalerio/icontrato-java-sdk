package br.com.idtrust.sdk.icontrato.ws.client.dto;

import java.io.Serializable;
import java.util.List;

public class DocumentDTO implements Serializable {

    private static final long serialVersionUID = -7699546983364062784L;

    public static enum DocumentType {
        PDF;
    }

    private String id;

    // private String owner;

    private String fileName;

    private DocumentType documentType = DocumentType.PDF;

    private String description;

    private String hash;

    private byte[] documentBytes;

    private List<StepDTO> steps;

    private String status;

    private String workflow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // public String getEmailOwner() {
    // return owner;
    // }
    //
    // public void setEmailOwner(String owner) {
    // this.owner = owner;
    // }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public byte[] getDocumentBytes() {
        return documentBytes;
    }

    public void setDocumentBytes(byte[] documentBytes) {
        this.documentBytes = documentBytes;
    }

    public List<StepDTO> getSteps() {
        return steps;
    }

    public void setSteps(List<StepDTO> steps) {
        this.steps = steps;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }
}
