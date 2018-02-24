package br.com.ubots.bot.weather;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.Entitys;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WeatherRequirementsTest {

    private WeatherRequirements weatherRequirements;
    @Before
    public void setUp() throws Exception {
        this.weatherRequirements = new WeatherRequirements();
    }

    @Test
    public void askForCity() {
        InnerMessage innerMessage = new InnerMessage("","", Intention.FALLBACK, new Entitys("", "test", "test"));
        List<FacebookResponse> facebookRespons = weatherRequirements.askForRequirementes(innerMessage);
        FacebookResponse facebookResponse = facebookRespons.get(0);
        assertTrue(facebookResponse.getMessage().getText().equals("Em qual cidade?"));
    }
    @Test
    public void askForDate() {
        InnerMessage innerMessage = new InnerMessage("","", Intention.FALLBACK, new Entitys("test", "", "test"));
        List<FacebookResponse> facebookRespons = weatherRequirements.askForRequirementes(innerMessage);
        FacebookResponse facebookResponse = facebookRespons.get(0);
        assertTrue(facebookResponse.getMessage().getText().equals("Quando?"));
    }
    @Test
    public void askForState() {
        InnerMessage innerMessage = new InnerMessage("","", Intention.FALLBACK, new Entitys("test", "test", ""));
        List<FacebookResponse> facebookRespons = weatherRequirements.askForRequirementes(innerMessage);
        FacebookResponse facebookResponse = facebookRespons.get(0);
        assertTrue(facebookResponse.getMessage().getText().equals("Qual a sigla do estado?"));
    }
}