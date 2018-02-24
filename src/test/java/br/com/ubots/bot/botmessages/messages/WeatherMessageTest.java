package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.Entitys;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.dto.weather.innerBody.Forecast;
import br.com.ubots.bot.intentions.Intention;
import br.com.ubots.bot.weather.WeatherClient;
import br.com.ubots.bot.weather.WeatherRequirements;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherMessageTest {
    private WeatherMessage weatherMessage;
    private WeatherClient weatherClient;
    @Before
    public void setUp() throws Exception {
        weatherClient = mock(WeatherClient.class);
        WeatherRequirements weatherRequirements = mock(WeatherRequirements.class);
        this.weatherMessage = new WeatherMessage(weatherClient, weatherRequirements);
    }

    @Test
    public void testValidation() {
        assertTrue(weatherMessage.validate(Intention.WEATHER));
    }

    @Test
    public void testWrongValidation() {
        assertFalse(weatherMessage.validate(Intention.AGE));
    }

    @Test
    public void build() {
        InnerMessage innerMessage = new InnerMessage("test", "test", Intention.WEATHER, new Entitys("test", "test", "test"));
        when(weatherClient.getForecast(innerMessage)).thenReturn(new Forecast("2018-02-19",
                22, "E", 22, "ensolarado", 22));
        List<FacebookResponse> responses = weatherMessage.build(innerMessage);
        FacebookResponse response = responses.get(0);
        assertTrue(response.getMessage().getText().equals("Data: 19/02/2018"
                                        + "\nTemperatura: 22.0"
                                        + "\nSensação termica: 22.0"
                                        + "\nPrevisão: ensolarado"
                                        + "\nVento: E"
                                        + "\nHumidade 22.0"));
    }
    @Test
    public void wrongBuild(){
        InnerMessage innerMessage = new InnerMessage("test", "test", Intention.WEATHER, new Entitys("test", "test", "test"));
        when(weatherClient.getForecast(innerMessage)).thenThrow(IllegalArgumentException.class);
        List<FacebookResponse> responses = weatherMessage.build(innerMessage);
        FacebookResponse response = responses.get(0);
        assertTrue(responses.size() > 1);
        assertTrue(response.getMessage().getText().equals("Previsão de tempo da cidade encontrada"));
    }
}