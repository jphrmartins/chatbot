package br.com.ubots.bot.dto.dialogFlow.responsebody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DialogFlowResult {
    private DialogFlowParameters parameters;
    private DialogFlowIntention metadata;

    public DialogFlowParameters getParameters() {
        return parameters;
    }

    public void setParameters(DialogFlowParameters parameters) {
        this.parameters = parameters;
    }

    public DialogFlowIntention getMetadata() {
        return metadata;
    }

    public void setMetadata(DialogFlowIntention metadata) {
        this.metadata = metadata;
    }
}
