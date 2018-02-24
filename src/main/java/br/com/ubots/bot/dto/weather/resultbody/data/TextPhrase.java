package br.com.ubots.bot.dto.weather.resultbody.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TextPhrase {
    private String reduced;

    public String getReduced() {
        return reduced;
    }

    public void setReduced(String reduced) {
        this.reduced = reduced;
    }
}
