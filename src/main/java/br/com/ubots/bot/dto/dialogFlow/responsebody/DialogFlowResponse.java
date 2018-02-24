package br.com.ubots.bot.dto.dialogFlow.responsebody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DialogFlowResponse {
    private DialogFlowResult result;

    public DialogFlowResult getResult() {
        return result;
    }

    public void setResult(DialogFlowResult result) {
        this.result = result;
    }
}
