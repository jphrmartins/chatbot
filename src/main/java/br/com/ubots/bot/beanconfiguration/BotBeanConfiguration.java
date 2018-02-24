package br.com.ubots.bot.beanconfiguration;

import br.com.ubots.bot.apis.DialogFlowApi;
import br.com.ubots.bot.botmessages.ResponseMessages;
import br.com.ubots.bot.botmessages.messages.*;
import br.com.ubots.bot.processmessage.Bot;
import br.com.ubots.bot.processmessage.MessageBuilder;
import br.com.ubots.bot.weather.WeatherClient;
import br.com.ubots.bot.weather.WeatherRequirements;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class BotBeanConfiguration {
    @Bean
    public Bot bot(DialogFlowApi dialogFlowApi, MessageBuilder messageBuilder){
        return new Bot(dialogFlowApi, messageBuilder);
    }
    @Bean
    public MessageBuilder messageBuilder(List<ResponseMessages> responseMessages){
        return new MessageBuilder(responseMessages);
    }
    @Bean
    public List<ResponseMessages> responseMessages(WeatherClient weatherClient, WeatherRequirements weatherRequirements) {
        return Arrays.asList(new AgeMessage(), new SaluteMessage(), new NameMessage(),
                new EmailMessage(), new WeatherMessage(weatherClient, weatherRequirements));
    }
}
