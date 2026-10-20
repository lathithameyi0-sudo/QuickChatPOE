import java.util.Random;

public class Message {
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private static int totalMessagesSent = 0;

    public Message(int messageNumber, String recipient, String messageText) {
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    public String generateMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    public boolean checkMessageID() {
        return messageID != null && messageID.length() == 10;
    }

    public boolean checkRecipientCell() {
        if (recipient == null) return false;
        return recipient.matches("^\\+27[6-8][0-9]{8}$");
    }

    public boolean checkMessageLength() {
        return messageText != null && messageText.length() <= 250;
    }

    public String createMessageHash() {
        if (messageText == null || messageText.trim().isEmpty()) return "";
        String[] words = messageText.trim().split("\\s+");
        String first = words[0];
        String last = words[words.length - 1];
        String idFirstTwo = messageID.substring(0, 2);
        return (idFirstTwo + ":" + messageNumber + ":" + first + last).toUpperCase();
    }

    public String sentMessage(int choice) {
        switch (choice) {
            case 1: totalMessagesSent++; return "Message successfully sent.";
            case 2: return "Press 0 to delete message.";
            case 3: return "Message disregarded.";
            default: return "Invalid choice.";
        }
    }

    public String printMessages() {
        return "MessageID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + messageText;
    }

    public static int returnTotalMessages() {
        return totalMessagesSent;
    }

    public String getMessageID() { return messageID; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
}
