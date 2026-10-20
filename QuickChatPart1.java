import javax.swing.JOptionPane;
import java.util.ArrayList;

public class QuickChatPart1 {
    public static void main(String[] args) {
        ArrayList<Message> sentMessages = new ArrayList<>();
        ArrayList<String> disregarded = new ArrayList<>();
        ArrayList<String> stored = new ArrayList<>();
        ArrayList<String> messageHashes = new ArrayList<>();
        ArrayList<String> messageIDs = new ArrayList<>();

        // --- PART 1 LOGIN (keep working) ---
        Login login = new Login("Lathitha", "Meyi");
        String reg = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27718693002");
        JOptionPane.showMessageDialog(null, reg);
        if (!reg.equals("User registered successfully.")) return;

        String user = JOptionPane.showInputDialog("Enter username:");
        String pass = JOptionPane.showInputDialog("Enter password:");
        JOptionPane.showMessageDialog(null, login.returnLoginStatus(user, pass));
        if (!login.loginUser(user, pass)) return;

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        int messageCount = 0;
        while (true) {
            String menu = "Choose an option:\n1) Send Messages\n2) Show recently sent messages\n3) Quit";
            String input = JOptionPane.showInputDialog(menu);
            if (input == null) break;
            int choice;
            try { choice = Integer.parseInt(input); } catch (Exception e) { continue; }

            if (choice == 1) {
                String numStr = JOptionPane.showInputDialog("How many messages do you want to send?");
                int num = Integer.parseInt(numStr);
                for (int i = 0; i < num; i++) {
                    messageCount++;
                    String recipient = JOptionPane.showInputDialog("Enter recipient (+27XXXXXXXXX):");
                    String text = JOptionPane.showInputDialog("Enter message (max 250 chars):");

                    Message msg = new Message(messageCount, recipient, text);

                    if (!msg.checkRecipientCell()) {
                        JOptionPane.showMessageDialog(null, "Cell phone number incorrectly formatted or does not contain international code.");
                        messageCount--; continue;
                    }
                    if (!msg.checkMessageLength()) {
                        int excess = text.length() - 250;
                        JOptionPane.showMessageDialog(null, "Message exceeds 250 characters by " + excess + ", please reduce number and try again.");
                        messageCount--; continue;
                    }

                    String options = "1) Send Message\n2) Disregard Message\n3) Store Message to send later";
                    int sendChoice = Integer.parseInt(JOptionPane.showInputDialog(msg.printMessages() + "\n\n" + options));
                    String result = msg.sentMessage(sendChoice);

                    if (sendChoice == 1) {
                        sentMessages.add(msg);
                        messageHashes.add(msg.getMessageHash());
                        messageIDs.add(msg.getMessageID());
                    } else if (sendChoice == 2) {
                        disregarded.add(msg.getMessageText());
                    } else if (sendChoice == 3) {
                        stored.add(msg.getMessageText());
                    }
                    JOptionPane.showMessageDialog(null, result);
                }
                JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.returnTotalMessages());

            } else if (choice == 2) {
                JOptionPane.showMessageDialog(null, "Coming Soon.");
            } else if (choice == 3) {
                JOptionPane.showMessageDialog(null, "Total messages sent: " + Message.returnTotalMessages() + "\nGoodbye!");
                break;
            }
        }
    }
}