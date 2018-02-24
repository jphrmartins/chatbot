package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.botmessages.ResponseMessages;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;

import java.util.ArrayList;
import java.util.List;

public class NameMessage implements ResponseMessages {
    @Override
    public boolean validate(Intention intention) {
        return Intention.NAME.equals(intention);
    }

    @Override
    public List<FacebookResponse> build(InnerMessage innerMessage) {
        List<FacebookResponse> facebookRespons = new ArrayList<>();
        facebookRespons.add(new FacebookResponse("RESPONSE", innerMessage.getSenderId(), randomizeMessage()));
        return facebookRespons;
    }

    private String randomizeMessage() {
        int result = (int)((Math.random()*2) + 1);
        if (result == 1){
            return "Me chamo Atlas";
        }
        return "Meu nome é Atlas";
    }
}
