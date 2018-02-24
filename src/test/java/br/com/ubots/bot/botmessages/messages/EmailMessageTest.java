package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailMessageTest {

    private EmailMessage emailMessage;

    @Before
    public void setUp() {
        this.emailMessage = new EmailMessage();
    }

    @Test
    public void testValidation() {
        assertTrue(emailMessage.validate(Intention.EMAIL));
    }

    @Test
    public void testWrongValidation() {
        assertFalse(emailMessage.validate(Intention.AGE));
    }

    @Test
    public void testBuild() {
        InnerMessage incomingMessage = new InnerMessage("mail@mailing.com", "test", Intention.EMAIL, null);
        List<FacebookResponse> responses = emailMessage.build(incomingMessage);
        FacebookResponse responseTest = responses.get(0);
        assertTrue(responses.size() > 1);
        assertTrue(responseTest.getMessage().getText().equals("Seu email: mail@mailing.com"));
        assertTrue(responseTest.getRecipient().getId().equals("test"));
    }
}