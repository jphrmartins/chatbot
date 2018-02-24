package br.com.ubots.bot.botmessages;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;

import java.util.List;

public interface ResponseMessages {
    public boolean validate(Intention intention);
    public List<FacebookResponse> build(InnerMessage innerMessage);
}
