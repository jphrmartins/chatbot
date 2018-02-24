package br.com.ubots.bot.dto.weather.resultbody.data;

public class ThermalSensation {
    private int max;
    private int min;

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
