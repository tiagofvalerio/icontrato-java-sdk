package br.com.idtrust.sdk.icontrato.model.assembler;

import java.util.ArrayList;
import java.util.List;

import br.com.idtrust.sdk.icontrato.model.ActionType;
import br.com.idtrust.sdk.icontrato.model.Step;
import br.com.idtrust.sdk.icontrato.ws.client.dto.StepDTO;
import br.com.idtrust.sdk.icontrato.ws.client.dto.WorkflowDTO;

public class WorkflowAssembler implements Assembler<List<Step>, WorkflowDTO> {

    @Override
    public WorkflowDTO assembly(List<Step> steps) {
        WorkflowDTO dto = new WorkflowDTO();

        for (Step step : steps) {
            StepDTO stepDTO = new StepDTO();
            stepDTO.setCpf(step.getCpf());
            stepDTO.setNome(step.getName());
            stepDTO.setEmail(step.getEmail());
            stepDTO.setDescription(step.getDescription());
            stepDTO.setAction(step.getAction().toString());
            stepDTO.setRole(step.getRole());
            dto.getSteps().add(stepDTO);
        }

        return dto;
    }

    @Override
    public List<Step> convert(WorkflowDTO workflowDTO) {
        List<Step> steps = new ArrayList<Step>();

        for (StepDTO stepDTO : workflowDTO.getSteps()) {
            Step step = new Step()
                    .withAction(ActionType.SIGN.toString()
                            .equals(stepDTO.getAction()) ? ActionType.SIGN
                                    : ActionType.APPROVE)
                    .withCpf(stepDTO.getCpf())
                    .withDescription(stepDTO.getDescription())
                    .withEmail(stepDTO.getEmail()).withNome(stepDTO.getNome())
                    .withRole(stepDTO.getRole());
            steps.add(step);
        }

        return steps;
    }

}
