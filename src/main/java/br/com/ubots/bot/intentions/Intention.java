package br.com.ubots.bot.intentions;

public enum Intention {
    SALUTE("SALUTE"),
    AGE("AGE"),
    EMAIL("EMAIL"),
    WEATHER("WEATHER"),
    NAME("NAME"),
    FALLBACK("FALLBACK");

    private final String intention;

    Intention(String intention) {
        this.intention = intention;
    }

}
