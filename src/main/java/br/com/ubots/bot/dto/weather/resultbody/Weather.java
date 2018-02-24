package br.com.ubots.bot.dto.weather.resultbody;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private List<ForecastWeather> data;

    public List<ForecastWeather> getData() {
        return data;
    }

    public void setData(List<ForecastWeather> data) {
        this.data = data;
    }


}
