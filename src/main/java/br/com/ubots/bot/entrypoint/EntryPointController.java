package br.com.ubots.bot.entrypoint;

import br.com.ubots.bot.apis.FacebookApi;
import br.com.ubots.bot.dto.facebook.Incomingtbody.FacebookIncoming;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.processmessage.Bot;
import br.com.ubots.bot.translator.FacebookMessageTranslator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EntryPointController {
    private Bot bot;
    private FacebookApi facebookApi;
    public EntryPointController(Bot bot, FacebookApi facebookApi) {
        this.bot = bot;
        this.facebookApi = facebookApi;
    }

    @RequestMapping(value = "/messenger", method = RequestMethod.GET)
    public String validateWebhook(@RequestParam("hub.challenge")String tokenFace){
        return tokenFace;
    }

    @RequestMapping(value = "/messenger", method = RequestMethod.POST)
    public ResponseEntity responseMessageFace(@RequestBody FacebookIncoming incomingMessage){
        List<FacebookResponse> responses = bot.makeResponse(FacebookMessageTranslator.fromFacebook(incomingMessage));
        facebookApi.sendResponse(responses);
        return ResponseEntity.ok().build();
    }

}
