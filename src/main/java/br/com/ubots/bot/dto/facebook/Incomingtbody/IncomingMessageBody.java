package br.com.ubots.bot.dto.facebook.Incomingtbody;

public class IncomingMessageBody {
    private Sender sender;
    private FacebookIncomingMessage message;

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public FacebookIncomingMessage getMessage() {
        return message;
    }

    public void setMessage(FacebookIncomingMessage message) {
        this.message = message;
    }
}
