package br.com.ubots.bot.dto.weather.resultbody;

import br.com.ubots.bot.dto.weather.resultbody.data.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastWeather {
    private String date;
    private Humidity humidity;
    private Wind wind;
    @JsonProperty("thermal_sensation")
    private ThermalSensation thermalSensation;
    @JsonProperty("text_icon")
    private TextIcon textIcon;
    private Temperature temperature;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public ThermalSensation getThermalSensation() {
        return thermalSensation;
    }

    public void setThermalSensation(ThermalSensation thermalSensation) {
        this.thermalSensation = thermalSensation;
    }

    public TextIcon getTextIcon() {
        return textIcon;
    }

    public void setTextIcon(TextIcon textIcon) {
        this.textIcon = textIcon;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}
