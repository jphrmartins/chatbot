package br.com.ubots.bot.processmessage;

import br.com.ubots.bot.botmessages.ResponseMessages;
import br.com.ubots.bot.botmessages.messages.*;
import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.Entitys;
import br.com.ubots.bot.dto.facebook.innerbody.Facebook;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.dto.weather.innerBody.Forecast;
import br.com.ubots.bot.intentions.Intention;
import br.com.ubots.bot.weather.WeatherClient;
import br.com.ubots.bot.weather.WeatherRequirements;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MessageBuilderTest {

    private MessageBuilder messageBuilder;
    private List<ResponseMessages> responseMessages;

    @Before
    public void setUp() throws Exception {
        this.responseMessages = new ArrayList<>();
        this.messageBuilder = new MessageBuilder(responseMessages);
    }

    @Test
    public void testGetNameResponse() {
        InnerMessage message = new InnerMessage("message", "testName", Intention.NAME, new Entitys());
        responseMessages.add(new NameMessage());

        FacebookResponse response = this.messageBuilder.getResponse(message).get(0);
        assertEquals("testName", response.getRecipient().getId());
        assertTrue(response.getMessage().getText().contains("Atlas"));
    }

    @Test
    public void testGetAgeResponse() {
        InnerMessage message = new InnerMessage("message", "testAge", Intention.AGE, new Entitys());
        responseMessages.add(new AgeMessage());

        FacebookResponse response = this.messageBuilder.getResponse(message).get(0);
        assertEquals("testAge", response.getRecipient().getId());
        assertTrue(response.getMessage().getText().contains("25 anos de idade"));
    }

    @Test
    public void testGetSaluteResponse() {
        InnerMessage message = new InnerMessage("message", "testSalute", Intention.SALUTE, new Entitys());
        responseMessages.add(new SaluteMessage());

        FacebookResponse response = this.messageBuilder.getResponse(message).get(0);
        assertEquals("testSalute", response.getRecipient().getId());
        assertTrue(response.getMessage().getText().contains("Olá"));
    }

    @Test
    public void testGetEmailResponse() {
        InnerMessage message = new InnerMessage("jphmartins@gmail.com", "testEmail", Intention.EMAIL, new Entitys());
        responseMessages.add(new EmailMessage());

        FacebookResponse response = this.messageBuilder.getResponse(message).get(0);
        assertEquals("testEmail", response.getRecipient().getId());
        assertTrue(response.getMessage().getText().contains("jphmartins@gmail.com"));
    }

    @Test
    public void testGetWeatherResponse() {
        InnerMessage message = new InnerMessage("message", "testWeather", Intention.WEATHER, new Entitys("cityTest", "timeTest", "stateTest"));

        WeatherRequirements weatherRequirements = mock(WeatherRequirements.class);
        WeatherClient weatherClient = mock(WeatherClient.class);
        when(weatherClient.getForecast(message)).thenReturn(new Forecast("2018-02-19", 22, "E", 22, "sol", 22));
        responseMessages.add(new WeatherMessage(weatherClient, weatherRequirements));

        FacebookResponse response = this.messageBuilder.getResponse(message).get(0);
        assertEquals("testWeather", response.getRecipient().getId());
        assertEquals("Data: 19/02/2018\nTemperatura: 22.0\nSensação termica: 22.0\nPrevisão: sol\nVento: E\nHumidade 22.0", response.getMessage().getText());
    }

    @Test
    public void testGetFallbackResponse() {
        InnerMessage message = new InnerMessage("fallbackme", "testFallback", Intention.FALLBACK, new Entitys());

        FacebookResponse response = this.messageBuilder.getResponse(message).get(0);
        assertEquals("testFallback", response.getRecipient().getId());
        assertEquals("Desculpa", response.getMessage().getText());
    }

    @Test
    public void testGetOffMessage() {
        Facebook facebook = new Facebook("testOffApi", "message");
        FacebookResponse response = this.messageBuilder.getOffMessage(facebook).get(0);

        assertEquals("testOffApi", response.getRecipient().getId());
        assertEquals("Não posso responder no momento", response.getMessage().getText());
    }
}