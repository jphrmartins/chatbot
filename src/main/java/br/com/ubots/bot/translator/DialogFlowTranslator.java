package br.com.ubots.bot.translator;

import br.com.ubots.bot.dto.dialogFlow.incomingbody.DialogFlow;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.Entitys;
import br.com.ubots.bot.dto.dialogFlow.responsebody.DialogFlowResponse;
import br.com.ubots.bot.intentions.Intention;

public class DialogFlowTranslator {
    public static DialogFlow toInner(DialogFlowResponse response) {
        Intention intention = getIntention(response);
        Entitys parameters = getParameters(response);
        return new DialogFlow(intention, parameters);
    }

    private static Entitys getParameters(DialogFlowResponse response) {
        String cityName = response.getResult().getParameters().getGeoCity();
        String date = response.getResult().getParameters().getDate();
        String state = response.getResult().getParameters().getState();
        return new Entitys(cityName, date, state);
    }

    private static Intention getIntention(DialogFlowResponse response) {
        String responseIntention = response.getResult().getMetadata().getIntentName();
        return Intention.valueOf(responseIntention);
    }

}
