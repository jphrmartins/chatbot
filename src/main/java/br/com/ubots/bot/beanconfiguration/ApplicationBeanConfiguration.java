package br.com.ubots.bot.beanconfiguration;

import br.com.ubots.bot.weather.WeatherRequirements;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Logger logger(InjectionPoint injectionPoint){
        return LoggerFactory.getLogger(injectionPoint.getMethodParameter().getContainingClass());
    }
    @Bean
    public WeatherRequirements weatherRequirements(){
        return new WeatherRequirements();
    }
}
