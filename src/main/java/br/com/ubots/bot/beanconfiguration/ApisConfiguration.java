package br.com.ubots.bot.beanconfiguration;

import br.com.ubots.bot.apis.Api;
import br.com.ubots.bot.apis.DialogFlowApi;
import br.com.ubots.bot.apis.FacebookApi;
import br.com.ubots.bot.apis.WeatherApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApisConfiguration {
    @Bean
    public WeatherApi weatherApi(ObjectMapper objectMapper, Api api, @Value("${url.weather}") String url, @Value("${token.weather}") String token, Logger logger) {
        return new WeatherApi(objectMapper, api, url, token, logger);
    }

    @Bean
    public DialogFlowApi dialogFlowApi(Logger logger, ObjectMapper objectMapper, Api api, @Value("${url.dialogflow}") String url, @Value("${token.dialogflow}") String token) {
        return new DialogFlowApi(objectMapper, api, url, token, logger);
    }

    @Bean
    public FacebookApi facebookApi(Logger logger, Gson gson, Api api, @Value("${url.facebook}") String url, @Value("${token.facebook}") String token) {
        return new FacebookApi(gson, api, url, token, logger);
    }
}
