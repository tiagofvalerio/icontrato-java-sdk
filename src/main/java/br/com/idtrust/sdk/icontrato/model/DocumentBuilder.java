package br.com.idtrust.sdk.icontrato.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DocumentBuilder implements Serializable {

    private static final long serialVersionUID = -255202990752668996L;

    private Document document;

    private List<String> tags;

    private List<Step> steps;

    public DocumentBuilder() {
        this.tags = new ArrayList<String>();
        this.steps = new ArrayList<Step>();
    }

    public Document getDocument() {
        return document;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public DocumentBuilder withDocument(String fileName,
            InputStream documentStream) {
        this.document = new Document(fileName, documentStream);
        return this;
    }

    public DocumentBuilder withTag(String tag) {
        getTags().add(tag);
        return this;
    }

    public DocumentBuilder withStep(String cpf, String name, String email,
            String description, ActionType action, String role) {
        Step step = new Step().withAction(action).withCpf(cpf)
                .withDescription(description).withEmail(email).withNome(name)
                .withRole(role);
        getSteps().add(step);
        return this;
    }
}