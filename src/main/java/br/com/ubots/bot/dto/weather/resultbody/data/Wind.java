package br.com.ubots.bot.dto.weather.resultbody.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {
    @JsonProperty("velocity_avg")
    private double velocityAvg;
    private String direction;

    public double getVelocityAvg() {
        return velocityAvg;
    }

    public void setVelocityAvg(double velocityAvg) {
        this.velocityAvg = velocityAvg;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
