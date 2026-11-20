import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    @Test
    public void testMessageLengthSuccess() {
        Message msg = new Message(1, "+27718693002", "Hi there");
        assertTrue(msg.checkMessageLength());
    }

    @Test
    public void testMessageLengthFailure() {
        String longText = "a".repeat(300);
        Message msg = new Message(1, "+27718693002", longText);
        assertFalse(msg.checkMessageLength());
    }

    @Test
    public void testCheckRecipientCellSuccess() {
        Message msg = new Message(1, "+27718693002", "Hello");
        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCellFailure() {
        Message msg = new Message(1, "0718693002", "Hello");
        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testMessageIDLength() {
        Message msg = new Message(1, "+27718693002", "Test");
        assertEquals(10, msg.getMessageID().length());
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testMessageHash() {
        Message msg = new Message(0, "+27718693002", "Hi there");
        String hash = msg.getMessageHash();
        assertNotNull(hash);
        assertTrue(hash.contains(":0:"));
    }

    @Test
    public void testSentMessageChoice1() {
        Message msg = new Message(1, "+27718693002", "Hello");
        String result = msg.sentMessage(1);
        assertEquals("Message successfully sent.", result);
    }

    @Test
    public void testTotalMessages() {
        int before = Message.returnTotalMessages();
        Message msg = new Message(1, "+27718693002", "Test");
        msg.sentMessage(1);
        assertEquals(before + 1, Message.returnTotalMessages());
    }
}
