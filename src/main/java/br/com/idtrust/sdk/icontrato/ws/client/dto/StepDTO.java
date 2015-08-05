package br.com.idtrust.sdk.icontrato.ws.client.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StepDTO implements Serializable {

    private static final long serialVersionUID = -8058589243099978347L;

    private String id;

    private String workflow;

    private String description;

    private String status;

    private String cpf;

    private String nome;

    private String email;

    private String action;

    private String role;

    private boolean grouping = false;

    private boolean done = false;

    private Boolean parallel = true;

    private List<StepDTO> steps;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public StepDTO() {
        this.steps = new ArrayList<StepDTO>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<StepDTO> getSteps() {
        return steps;
    }

    public void setSteps(List<StepDTO> steps) {
        this.steps = steps;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isGrouping() {
        return grouping;
    }

    public void setGrouping(boolean grouping) {
        this.grouping = grouping;
    }

    public Boolean getParallel() {
        return parallel;
    }

    public void setParallel(Boolean parallel) {
        this.parallel = parallel;
    }

    @Override
    public String toString() {
        return "StepDTO [id=" + id + ", workflow=" + workflow + ", description="
                + description + ", status=" + status + ", cpf=" + cpf
                + ", nome=" + nome + ", email=" + email + ", action=" + action
                + ", role=" + role + ", grouping=" + grouping + ", done=" + done
                + ", parallel=" + parallel + ", steps=" + steps + "]";
    }

}
