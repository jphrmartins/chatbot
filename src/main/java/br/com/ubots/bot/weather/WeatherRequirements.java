package br.com.ubots.bot.weather;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;

import java.util.Arrays;
import java.util.List;

public class WeatherRequirements {
    public List<FacebookResponse> askForRequirementes(InnerMessage message) {
        if (message.getEntitys().getDate().isEmpty()) {
            return askForDate(message.getSenderId());
        } else if (message.getEntitys().getCityName().isEmpty()) {
            return askForCity(message.getSenderId());
        } else {
            return askForState(message.getSenderId());
        }
    }

    private List<FacebookResponse> askForState(String senderId) {
        return Arrays.asList(new FacebookResponse("RESPONSE", senderId, "Qual a sigla do estado?"));
    }

    private List<FacebookResponse> askForCity(String senderId) {
        return Arrays.asList(new FacebookResponse("RESPONSE", senderId, "Em qual cidade?"));
    }

    private List<FacebookResponse> askForDate(String senderId) {
        return Arrays.asList(new FacebookResponse("RESPONSE", senderId, "Quando?"));
    }
}
