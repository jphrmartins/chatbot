package br.com.ubots.bot.dto.dialogFlow.incomingbody;

import java.text.SimpleDateFormat;

public class Entitys {
    private String cityName;
    private String date;
    private String state;

    public Entitys() {
    }

    public Entitys(String cityName, String date, String state) {
        this.cityName = cityName;
        this.date = date;
        this.state = state;
    }

    public String getCityName() {
        return cityName;
    }

    public String getState() {
        return state;
    }

    public String getDate() {
        return date;
    }
}
