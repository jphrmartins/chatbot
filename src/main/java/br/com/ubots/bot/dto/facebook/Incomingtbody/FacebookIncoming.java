package br.com.ubots.bot.dto.facebook.Incomingtbody;

import java.util.List;

public class FacebookIncoming {
    private List<FacebookEntryData> entry;

    public List<FacebookEntryData> getEntry() {
        return entry;
    }

    public void setEntry(List<FacebookEntryData> entry) {
        this.entry = entry;
    }
}
