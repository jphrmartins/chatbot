package br.com.ubots.bot.processmessage;

import br.com.ubots.bot.botmessages.ResponseMessages;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.innerbody.Facebook;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageBuilder {
    private List<ResponseMessages> responseMessages;

    public MessageBuilder(List<ResponseMessages> responseMessages) {
        this.responseMessages = responseMessages;
    }

    public List<FacebookResponse> getResponse(InnerMessage innerMessage) {
        for (ResponseMessages messages : responseMessages) {
            if (messages.validate(innerMessage.getIntention())) {
                return messages.build(innerMessage);
            }
        }
        return fallBackMessage(innerMessage.getSenderId());
    }

    private List<FacebookResponse> fallBackMessage(String senderId) {
        List<FacebookResponse> facebookRespons = new ArrayList<>();
        facebookRespons.add(new FacebookResponse("RESPONSE", senderId, "Desculpa"));
        facebookRespons.add(new FacebookResponse("RESPONSE", senderId, "Não entendi o que você quis dizer"));
        return facebookRespons;
    }

    public List<FacebookResponse> getOffMessage(Facebook facebook) {
        List<FacebookResponse> facebookRespons = new ArrayList<>();
        facebookRespons.add(new FacebookResponse("RESPONSE", facebook.getSenderId(), "Não posso responder no momento"));
        facebookRespons.add(new FacebookResponse("RESPONSE", facebook.getSenderId(), "Por favor tente mais tarde"));
        facebookRespons.add(new FacebookResponse("RESPONSE", facebook.getSenderId(), "Desculpe o transtorno"));
        return facebookRespons;
    }
}
