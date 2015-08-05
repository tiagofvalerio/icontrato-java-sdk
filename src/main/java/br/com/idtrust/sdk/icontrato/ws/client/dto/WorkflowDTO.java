package br.com.idtrust.sdk.icontrato.ws.client.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WorkflowDTO implements Serializable {

    private static final long serialVersionUID = -1140858553230206940L;

    private String documentHash;

    private List<String> tags;

    private List<StepDTO> steps;

    public WorkflowDTO() {
        this.tags = new ArrayList<>();
        this.steps = new ArrayList<>();
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<StepDTO> getSteps() {
        return steps;
    }

    public void setSteps(List<StepDTO> steps) {
        this.steps = steps;
    }

    public String getDocumentHash() {
        return documentHash;
    }

    public void setDocumentHash(String documentHash) {
        this.documentHash = documentHash;
    }

}
