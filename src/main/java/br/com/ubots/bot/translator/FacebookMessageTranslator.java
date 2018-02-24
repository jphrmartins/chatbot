package br.com.ubots.bot.translator;

import br.com.ubots.bot.dto.facebook.Incomingtbody.FacebookIncoming;
import br.com.ubots.bot.dto.facebook.innerbody.Facebook;

public class FacebookMessageTranslator {
    public static Facebook fromFacebook(FacebookIncoming incomingMessage) {
        String senderId = incomingMessage.getEntry().get(0).getMessaging().get(0).getSender().getId();
        String message = incomingMessage.getEntry().get(0).getMessaging().get(0).getMessage().getText().toLowerCase();
        return new Facebook(senderId, message);
    }

}
