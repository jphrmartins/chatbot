package br.com.ubots.bot.weather;

import br.com.ubots.bot.apis.WeatherApi;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.Entitys;
import br.com.ubots.bot.dto.weather.innerBody.Forecast;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherClient {

    private WeatherApi weatherApi;

    public WeatherClient(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public Forecast getForecast(InnerMessage message) {
        String cityName = message.getEntitys().getCityName();
        String state = message.getEntitys().getState();
        long cityId = weatherApi.getCityId(cityName, state);
        return generateForecast(cityId, message.getEntitys());
    }

    private Forecast generateForecast(long cityId, Entitys parameters) {
        List<Forecast> forecastList = weatherApi.
                getWeather(cityId);
        return getForecastSpecificDay(parameters, forecastList);
    }

    private Forecast getForecastSpecificDay(Entitys parameters, List<Forecast> forecastList) {
        for (Forecast forecastInner : forecastList) {
            if (parameters.getDate().equals(forecastInner.getData())) {
                return forecastInner;
            }
        }
        throw new IllegalArgumentException();
    }
}
