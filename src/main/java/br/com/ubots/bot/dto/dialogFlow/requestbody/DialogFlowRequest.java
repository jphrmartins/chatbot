package br.com.ubots.bot.dto.dialogFlow.requestbody;

public class DialogFlowRequest {
    private String lang;
    private String query;
    private String sessionId;

    public DialogFlowRequest(String query, String sessionId) {
        this.lang = "pt-BR";
        this.query = query;
        this.sessionId = sessionId;
    }

    public String getLang() {
        return lang;
    }

    public String getQuery() {
        return query;
    }

    public String getSessionId() {
        return sessionId;
    }
}
