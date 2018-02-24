package br.com.ubots.bot.dto.facebook.Incomingtbody;

import java.util.List;

public class FacebookEntryData {

    private List<IncomingMessageBody> messaging;

    public List<IncomingMessageBody> getMessaging() {
        return messaging;
    }

    public void setMessaging(List<IncomingMessageBody> messaging) {
        this.messaging = messaging;
    }
}
