package br.com.idtrust.sdk.icontrato.model;

import java.io.Serializable;

public class Step implements Serializable {

    private static final long serialVersionUID = 4146497150008648399L;

    private String cpf;

    private String name;

    private String email;

    private String description;

    private ActionType action;

    private String role;

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public ActionType getAction() {
        return action;
    }

    public String getRole() {
        return role;
    }

    public Step withCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Step withNome(String name) {
        this.name = name;
        return this;
    }

    public Step withEmail(String email) {
        this.email = email;
        return this;
    }

    public Step withDescription(String description) {
        this.description = description;
        return this;
    }

    public Step withAction(ActionType action) {
        this.action = action;
        return this;
    }

    public Step withRole(String role) {
        this.role = role;
        return this;
    }
}
