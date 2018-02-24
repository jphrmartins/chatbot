package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SaluteMessageTest {

    private SaluteMessage saluteMessage;

    @Before
    public void setUp() {
        this.saluteMessage = new SaluteMessage();
    }

    @Test
    public void testValidate() {
        assertTrue(saluteMessage.validate(Intention.SALUTE));
    }

    @Test
    public void testWrongValidate() {
        assertFalse(saluteMessage.validate(Intention.AGE));
    }

    @Test
    public void testBuild() {
        InnerMessage incomingMessage = new InnerMessage("ola", "test", Intention.SALUTE, null);
        List<FacebookResponse> responsesTest = saluteMessage.build(incomingMessage);
        FacebookResponse response = responsesTest.get(0);
        assertTrue(responsesTest.size() > 1);
        assertTrue(response.getMessage().getText().equals("Olá"));
        assertTrue(response.getRecipient().getId().equals("test"));
    }
}