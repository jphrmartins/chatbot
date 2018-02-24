package br.com.ubots.bot.dto.facebook.outgoingbody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FacebookResponse {
    @JsonProperty("messaging_type")
    private String messagingType;
    private RecipientResponse recipient;
    private TextMessage message;

    public FacebookResponse(String messagingType, String recipient, String message) {
        this.messagingType = messagingType;
        this.recipient = new RecipientResponse(recipient);
        this.message = new TextMessage(message);
    }

    public String getMessagingType() {
        return messagingType;
    }

    public RecipientResponse getRecipient() {
        return recipient;
    }

    public TextMessage getMessage() {
        return message;
    }
}
