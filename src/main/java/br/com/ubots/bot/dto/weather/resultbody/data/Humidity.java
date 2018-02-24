package br.com.ubots.bot.dto.weather.resultbody.data;

public class Humidity {
    private int min;
    private int max;

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
