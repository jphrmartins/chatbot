package br.com.ubots.bot.botmessages.messages;

import br.com.ubots.bot.dto.bot.InnerMessage;
import br.com.ubots.bot.dto.dialogFlow.incomingbody.Entitys;
import br.com.ubots.bot.dto.facebook.outgoingbody.FacebookResponse;
import br.com.ubots.bot.intentions.Intention;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AgeMessageTest {
    private AgeMessage ageMessage;

    @Before
    public void setUp(){
        this.ageMessage = new AgeMessage();
    }
    @Test
    public void testValidation() {
        assertTrue(ageMessage.validate(Intention.AGE));
    }
    @Test
    public void testWrongValidation() {
        assertFalse(ageMessage.validate(Intention.NAME));
    }

    @Test
    public void testBuildMessage() {
        InnerMessage message = new InnerMessage("sua idade", "test", Intention.AGE, new Entitys());
        List<FacebookResponse> responseListTest = ageMessage.build(message);
        FacebookResponse response = responseListTest.get(0);
        assertTrue(response.getRecipient().getId().equals("test"));
        assertTrue(response.getMessage().getText().contains("25 anos de idade"));
    }
}