package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.botmessages.ResponseMessages;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;

import java.util.ArrayList;
import java.util.List;

public class EmailMessage implements ResponseMessages {


    @Override
    public boolean validate(Intention intention) {
        return Intention.EMAIL.equals(intention);
    }

    @Override
    public List<FacebookResponse> build(InnerMessage innerMessage) {
        try {
            return locatedEmail(innerMessage);
        } catch (IllegalArgumentException e) {
            return unlocatedEmail(innerMessage.getSenderId());
        }
    }

    private List<FacebookResponse> unlocatedEmail(String senderId) {
        List<FacebookResponse> facebookRespons = new ArrayList<>();
        facebookRespons.add(new FacebookResponse("RESPONSE", senderId, "Seu email não está valido"));
        return facebookRespons;
    }

    private List<FacebookResponse> locatedEmail(InnerMessage innerMessage) {
        List<FacebookResponse> facebookRespons = new ArrayList<>();
        facebookRespons.add(new FacebookResponse("RESPONSE", innerMessage.getSenderId(), "Seu email: " + getEmail(innerMessage.getMessage())));
        facebookRespons.add(new FacebookResponse("RESPONSE", innerMessage.getSenderId(), "Está valido"));
        return facebookRespons;
    }

    private String getEmail(String userMessage) {
        String[] userMassageSplited = userMessage.split("[ ]");
        for (int i = 0; i < userMassageSplited.length; i++) {
            if (userMassageSplited[i].matches("(^[a-z])([a-z]|[_]|[.])*[@][a-z]*(\\.(?!\\.)[a-z]*)*([a-z]$)")) {
                return userMassageSplited[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
