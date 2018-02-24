package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.botmessages.ResponseMessages;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;

import java.util.ArrayList;
import java.util.List;

public class SaluteMessage implements ResponseMessages {
    @Override
    public boolean validate(Intention intention) {
        return Intention.SALUTE.equals(intention);
    }

    @Override
    public List<FacebookResponse> build(InnerMessage innerMessage) {
        List<FacebookResponse> responseMessages = new ArrayList<>();
        responseMessages.add(new FacebookResponse("RESPONSE", innerMessage.getSenderId(), "Olá"));
        responseMessages.add(new FacebookResponse("RESPONSE", innerMessage.getSenderId(), "Por favor, informe seu email..."));
        return responseMessages;
    }
}
