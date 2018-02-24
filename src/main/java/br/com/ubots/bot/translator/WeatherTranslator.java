package br.com.ubots.bot.translator;

import br.com.ubots.bot.dto.weather.innerBody.Forecast;
import br.com.ubots.bot.dto.weather.resultbody.ForecastWeather;

import java.util.ArrayList;
import java.util.List;

public class WeatherTranslator {
    public static List<Forecast> toInner(List<ForecastWeather> incomingForecastList){
        List<Forecast> forecastInners = new ArrayList<>();
        for (ForecastWeather forecastWeather: incomingForecastList) {

            String data = forecastWeather.getDate();
            String wind = "Velocidade: " + forecastWeather.getWind().getVelocityAvg() + " Direção: " + forecastWeather.getWind().getDirection();
            String forecastText = forecastWeather.getTextIcon().getText().getPhrase().getReduced();

            double humidity = getAverage(forecastWeather.getHumidity().getMax(), forecastWeather.getHumidity().getMin());
            double termalSensation = getAverage(forecastWeather.getThermalSensation().getMax(), forecastWeather.getThermalSensation().getMin());
            double temperature = getAverage(forecastWeather.getTemperature().getMax(), forecastWeather.getTemperature().getMin());

            forecastInners.add(new Forecast(data, humidity, wind, termalSensation, forecastText, temperature));
        }
        return forecastInners;
    }

    private static double getAverage(int max, int min) {
        return (max + min) / 2;
    }
}
