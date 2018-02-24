package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NameMessageTest {
    private NameMessage nameMessage;
    @Before
    public void setUp(){
        this.nameMessage = new NameMessage();
    }
    @Test
    public void testValidation() {
        assertTrue(nameMessage.validate(Intention.NAME));
    }
    @Test
    public void testWrongValidation() {
        assertFalse(nameMessage.validate(Intention.AGE));
    }

    @Test
    public void tesstBuild() {
        InnerMessage incomingMessage = new InnerMessage("seu nome", "test", Intention.NAME, null);
        List<FacebookResponse> responsesTest = nameMessage.build(incomingMessage);
        FacebookResponse facebookResponse = responsesTest.get(0);
        assertTrue(facebookResponse.getMessage().getText().contains("Atlas"));
        assertTrue(facebookResponse.getRecipient().getId().equals("test"));
    }
}