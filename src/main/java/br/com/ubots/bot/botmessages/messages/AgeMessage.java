package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.botmessages.ResponseMessages;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;

import java.util.ArrayList;
import java.util.List;

public class AgeMessage implements ResponseMessages {

    @Override
    public boolean validate(Intention intention) {
        return Intention.AGE.equals(intention);
    }

    @Override
    public List<FacebookResponse> build(InnerMessage innerMessage) {
        List<FacebookResponse> facebookRespons = new ArrayList<>();
        facebookRespons.add(new FacebookResponse("RESPONSE", innerMessage.getSenderId(), randomMessage()));
        return facebookRespons;
    }

    private String randomMessage() {
        int choice = (int) (Math.random() * 3) + 1;
        if (choice == 1){
            return "Tenho 25 anos de idade";
        } else if(choice == 2){
            return "Possuo 25 anos de idade";
        }
        return "Fui Criado com 25 anos de idade";
    }
}
