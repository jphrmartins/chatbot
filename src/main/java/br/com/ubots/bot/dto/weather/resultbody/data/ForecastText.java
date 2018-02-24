package br.com.ubots.bot.dto.weather.resultbody.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastText {
    private TextPhrase phrase;

    public TextPhrase getPhrase() {
        return phrase;
    }

    public void setPhrase(TextPhrase phrase) {
        this.phrase = phrase;
    }
}
