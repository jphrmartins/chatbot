package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.botmessages.ResponseMessages;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.dto.weather.innerBody.Forecast;
import br.com.ubots.bot.intentions.Intention;
import br.com.ubots.bot.weather.WeatherClient;
import br.com.ubots.bot.weather.WeatherRequirements;

import java.util.ArrayList;
import java.util.List;

public class WeatherMessage implements ResponseMessages {

    private WeatherClient weatherClient;
    private WeatherRequirements weatherRequirements;

    public WeatherMessage(WeatherClient weatherClient, WeatherRequirements weatherRequirements) {
        this.weatherClient = weatherClient;
        this.weatherRequirements = weatherRequirements;
    }

    @Override
    public boolean validate(Intention intention) {
        return Intention.WEATHER.equals(intention);
    }

    @Override
    public List<FacebookResponse> build(InnerMessage innerMessage) {
        try {
            return generateMessage(innerMessage);
        } catch (IllegalArgumentException e) {
            return caseForecastOutLimit(innerMessage.getSenderId());
        }
    }

    private List<FacebookResponse> generateMessage(InnerMessage innerMessage) {
        if (entityIsEmpity(innerMessage)) {
            return weatherRequirements.askForRequirementes(innerMessage);
        }
        Forecast forecast = weatherClient.getForecast(innerMessage);
        return makeResponse(forecast, innerMessage.getSenderId());
    }

    private List<FacebookResponse> makeResponse(Forecast forecast, String senderId) {
        List<FacebookResponse> facebookRespons = new ArrayList<>();
        facebookRespons.add(new FacebookResponse("RESPONSE", senderId,
                "Data: " + ajustData(forecast.getData())
                        + "\nTemperatura: " + forecast.getTemperature()
                        + "\nSensação termica: " + forecast.getThermalSensation()
                        + "\nPrevisão: " + forecast.getText()
                        + "\nVento: " + forecast.getWind()
                        + "\nHumidade " + forecast.getHumidity()));
        return facebookRespons;
    }

    private String ajustData(String data) {
        String[] dataSplited = data.split("[-]");
        StringBuffer ajustData = new StringBuffer("");
        for (int i = dataSplited.length - 1; i >= 0; i--) {
            ajustData.append(dataSplited[i] + "/");
        }
        return ajustData.substring(0, ajustData.length() - 1);
    }

    private List<FacebookResponse> caseForecastOutLimit(String senderId) {
        List<FacebookResponse> facebookRespons = new ArrayList<>();
        facebookRespons.add(new FacebookResponse("RESPONSE", senderId, "Previsão de tempo da cidade encontrada"));
        facebookRespons.add(new FacebookResponse("RESPONSE", senderId, "Dia desejado para a previsão não encontrada"));
        facebookRespons.add(new FacebookResponse("RESPONSE", senderId, "Tente um dia entre 15 dias pra frente de hoje"));
        return facebookRespons;
    }

    private boolean entityIsEmpity(InnerMessage innerMessage) {
        return innerMessage.getEntitys().getDate().isEmpty() || innerMessage.getEntitys().getState().isEmpty() || innerMessage.getEntitys().getCityName().isEmpty();
    }
}
