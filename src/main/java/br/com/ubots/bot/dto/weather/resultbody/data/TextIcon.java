package br.com.ubots.bot.dto.weather.resultbody.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextIcon {
    private ForecastText text;

    public ForecastText getText() {
        return text;
    }

    public void setText(ForecastText text) {
        this.text = text;
    }
}
