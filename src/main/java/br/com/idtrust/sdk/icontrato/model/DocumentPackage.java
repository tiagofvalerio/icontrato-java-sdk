package br.com.idtrust.sdk.icontrato.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DocumentPackage implements Serializable {

    private static final long serialVersionUID = -255202990752668996L;

    private String userName;

    private String password;

    private Document document;

    private List<String> tags;

    private List<Step> steps;

    public DocumentPackage() {
        this.tags = new ArrayList<String>();
        this.steps = new ArrayList<Step>();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
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

    public DocumentPackage withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public DocumentPackage withPassword(String password) {
        this.password = password;
        return this;
    }

    public DocumentPackage withDocument(String emailOwner, String fileName,
            InputStream documentStream) {
        this.document = new Document(emailOwner, fileName, documentStream);
        return this;
    }

    public DocumentPackage withTag(String tag) {
        getTags().add(tag);
        return this;
    }

    public DocumentPackage withStep(String cpf, String name, String email,
            String description, ActionType action, String role) {
        Step step = new Step().withAction(action).withCpf(cpf)
                .withDescription(description).withEmail(email).withNome(name)
                .withRole(role);
        getSteps().add(step);
        return this;
    }
}