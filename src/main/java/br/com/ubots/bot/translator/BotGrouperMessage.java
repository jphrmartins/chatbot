package br.com.ubots.bot.translator;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.DialogFlow;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.Entitys;
import br.com.ubots.bot.dto.facebook.innerbody.Facebook;
import br.com.ubots.bot.intentions.Intention;

public class BotGrouperMessage {

    public static InnerMessage groupMessage(DialogFlow dialogFlow, Facebook facebook){
        String message = facebook.getMessage();
        String senderId = facebook.getSenderId();
        Intention intention = dialogFlow.getIntention();
        Entitys parameters = new Entitys(dialogFlow.getParameters().getCityName(), dialogFlow.getParameters().getDate(), dialogFlow.getParameters().getState());
        return new InnerMessage(message, senderId, intention, parameters);
    }
}
