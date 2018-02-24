package br.com.ubots.bot.processmessage;

import br.com.ubots.bot.apis.exception.ApiOffException;
import br.com.ubots.bot.apis.DialogFlowApi;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.DialogFlow;
import br.com.ubots.bot.dto.dialogFlow.requestbody.DialogFlowRequest;
import br.com.ubots.bot.dto.facebook.innerbody.Facebook;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.translator.BotGrouperMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bot {
    private DialogFlowApi apiDialogFlow;
    private MessageBuilder messageBuilder;

    public Bot(DialogFlowApi apiDialogFlow, MessageBuilder messageBuilder) {
        this.apiDialogFlow = apiDialogFlow;
        this.messageBuilder = messageBuilder;
    }

    public List<FacebookResponse> makeResponse(Facebook facebook) {
        try {
            DialogFlow dialogFlow = getIntentionDialogFlow(facebook);
            InnerMessage message = BotGrouperMessage.groupMessage(dialogFlow, facebook);
            return messageBuilder.getResponse(message);
        } catch (ApiOffException e) {
            return messageBuilder.getOffMessage(facebook);
        }

    }

    private DialogFlow getIntentionDialogFlow(Facebook facebook) {
        DialogFlowRequest dialogFlowRequest = new DialogFlowRequest(facebook.getMessage(), facebook.getSenderId());
        return apiDialogFlow.getIntention(dialogFlowRequest);
    }
}
