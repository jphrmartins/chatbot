package br.com.ubots.bot.apis;

import br.com.ubots.bot.apis.exception.ApiOffException;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.DialogFlow;
import br.com.ubots.bot.dto.dialogFlow.requestbody.DialogFlowRequest;
import br.com.ubots.bot.dto.dialogFlow.responsebody.DialogFlowResponse;
import br.com.ubots.bot.intentions.Intention;
import br.com.ubots.bot.translator.DialogFlowTranslator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

public class DialogFlowApi {

    private ObjectMapper objectMapper;
    private Api api;
    private String url;
    private String token;
    private Logger logger;

    public DialogFlowApi(ObjectMapper objectMapper, Api api, String url, String token, Logger logger) {
        this.objectMapper = objectMapper;
        this.api = api;
        this.url = url;
        this.token = token;
        this.logger = logger;
    }

    public DialogFlow getIntention(DialogFlowRequest request) {
        try {
            return DialogFlowTranslator.toInner(makeRequest(request));
        } catch (HttpClientErrorException e) {
            logger.error("DialogFlow Error" + e.toString());
            return new DialogFlow(Intention.FALLBACK);
        } catch (HttpServerErrorException e ){
            logger.error("DialogFlow Off" + e.toString());
            throw new ApiOffException();
        }
    }

    private DialogFlowResponse makeRequest(DialogFlowRequest request) {
        try {
            HttpHeaders headers = setHeaders();
            HttpEntity<String> json = new HttpEntity<String>(objectMapper.writeValueAsString(request), headers);
            String jsonResponse = api.post(json, URI.create(url));
            DialogFlowResponse response = objectMapper.readValue(jsonResponse, DialogFlowResponse.class);
            logger.info("intention [" + response.getResult().getMetadata().getIntentName() + "]");
            return response;
        } catch (IOException e) {
            logger.error("DialogFlow Serialize error");
            throw new ApiOffException();
        }
    }

    private HttpHeaders setHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.setContentType(applicationJson());
        return headers;
    }

    private MediaType applicationJson() {
        return new MediaType("application", "json", Charset.forName("UTF-8"));
    }
}
