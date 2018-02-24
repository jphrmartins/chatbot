package br.com.ubots.bot.dto.bot;

import br.com.ubots.bot.dto.dialogFlow.incomingbody.Entitys;
import br.com.ubots.bot.intentions.Intention;

public class InnerMessage {
    private String message;
    private String senderId;
    private Intention intention;
    private Entitys entitys;

    public InnerMessage(String message, String senderId, Intention intention, Entitys entitys) {
        this.message = message;
        this.senderId = senderId;
        this.intention = intention;
        this.entitys = entitys;
    }

    public String getMessage() {
        return message;
    }

    public String getSenderId() {
        return senderId;
    }

    public Intention getIntention() {
        return intention;
    }

    public Entitys getEntitys() {
        return entitys;
    }
}
