package br.com.ubots.bot.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
public class Api {

    private RestTemplate restTemplate;

    @Autowired
    public Api(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String post(HttpEntity<String> json, URI uri) {
        ResponseEntity<String> response = restTemplate.postForEntity(uri,json, String.class);
        return response.getBody();
    }

    public String get(URI uri){
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return response.getBody();
    }
}
