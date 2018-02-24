package br.com.ubots.bot.apis;

import br.com.ubots.bot.apis.exception.ApiOffException;
import br.com.ubots.bot.dto.weather.innerBody.Forecast;
import br.com.ubots.bot.dto.weather.resultbody.City;
import br.com.ubots.bot.dto.weather.resultbody.Weather;
import br.com.ubots.bot.translator.WeatherTranslator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.List;


public class WeatherApi {

    private Api api;
    private ObjectMapper objectMapper;
    private String url;
    private String token;
    private Logger logger;

    public WeatherApi(ObjectMapper objectMapper, Api api, String url, String token, Logger logger) {
        this.objectMapper = objectMapper;
        this.url = url;
        this.token = token;
        this.logger = logger;
    }

    public List<Forecast> getWeather(long cityId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            URI uri = URI.create(url + "forecast/locale/" + cityId + "/days/15?" + token);
            String response = api.get(uri);
            Weather weather = objectMapper.readValue(response, Weather.class);
            return WeatherTranslator.toInner(weather.getData());
        } catch (IOException e) {
            logger.error("Error From json");
            throw new ApiOffException();
        }
    }

    public long getCityId(String cityName, String state) {
        try {
            return makeRequestCity(cityName, state);
        } catch (HttpStatusCodeException e) {
            logger.error("WeatherApi error" + e.toString());
            throw new ApiOffException();
        }
    }

    private long makeRequestCity(String cityName, String state) {
        try {
            cityName = format(cityName);
            URI uri = URI.create(url + "locale/city?name=" + cityName + "&state=" + state + "&" + token);
            String result = api.get(uri);
            City[] resultCityId = objectMapper.readValue(result, City[].class);
            return resultCityId[0].getId();
        }catch (IOException e){
            logger.error("Error From json");
            throw new ApiOffException();
        }
    }

    private String format(String cityName) {
        return cityName.replaceAll("[ ]", "%20");
    }

}

