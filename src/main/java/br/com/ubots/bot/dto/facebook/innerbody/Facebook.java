package br.com.ubots.bot.dto.facebook.innerbody;

public class Facebook {
    private String senderId;
    private String message;

    public Facebook(String senderId, String message) {
        this.senderId = senderId;
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }


    public String getMessage() {
        return message;
    }

}
