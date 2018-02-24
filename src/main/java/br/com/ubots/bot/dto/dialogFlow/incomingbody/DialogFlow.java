package br.com.ubots.bot.dto.dialogFlow.incomingbody;

import br.com.ubots.bot.intentions.Intention;

public class DialogFlow {
    private Intention intention;
    private Entitys parameters;


    public DialogFlow(Intention intention, Entitys parameters) {
        this.intention = intention;
        this.parameters = parameters;
    }

    public DialogFlow(Intention intention) {
        this.intention = intention;
    }

    public Intention getIntention() {
        return intention;
    }

    public Entitys getParameters() {
        return parameters;
    }
}
