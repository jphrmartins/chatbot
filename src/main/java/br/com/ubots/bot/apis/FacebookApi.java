package br.com.ubots.bot.apis;

import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpStatusCodeException;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

public class FacebookApi {
    private Gson gson;
    private Api api;
    private String urlSenderApi;
    private Logger logger;

    public FacebookApi(Gson gson, Api api, String url, String token, Logger logger) {
        this.gson = gson;
        this.api = api;
        this.urlSenderApi = url+token;
        this.logger = logger;
    }

    public void sendResponse(List<FacebookResponse> messages) {
        try {
            request(messages);
        } catch(HttpStatusCodeException e){
           logger.error(e.toString());
        }

    }

    private void request(List<FacebookResponse> messages) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(applicationJson());
        URI uri = URI.create(urlSenderApi);
        for (FacebookResponse facebookResponse : messages) {
            HttpEntity<String> json = new HttpEntity<String>(gson.toJson(facebookResponse), headers);
            api.post(json, uri);
        }
    }

    private MediaType applicationJson() {
        return new MediaType("application", "json", Charset.forName("UTF-8"));
    }
}
