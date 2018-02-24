package br.com.ubots.bot.dto.weather.innerBody;

public class Forecast {
    private String data;
    private double humidity;
    private String wind;
    private double thermalSensation;
    private String text;
    private double temperature;

    public Forecast(String data, double humidity, String wind, double thermalSensation, String text, double temperature) {
        this.data = data;
        this.humidity = humidity;
        this.wind = wind;
        this.thermalSensation = thermalSensation;
        this.text = text;
        this.temperature = temperature;
    }

    public String getData() {
        return data;
    }

    public double getHumidity() {
        return humidity;
    }

    public String getWind() {
        return wind;
    }

    public double getThermalSensation() {
        return thermalSensation;
    }

    public String getText() {
        return text;
    }

    public double getTemperature() {
        return temperature;
    }
}
