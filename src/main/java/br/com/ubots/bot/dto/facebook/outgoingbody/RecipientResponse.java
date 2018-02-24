package br.com.ubots.bot.dto.facebook.outgoingbody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipientResponse {
    private String id;

    public RecipientResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
