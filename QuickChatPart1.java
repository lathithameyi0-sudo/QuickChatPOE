import java.util.Scanner;
public class QuickChatPart1 {
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.println("=================================");
System.out.println(" Welcome to QuickChat");
System.out.println("=================================");
System.out.print("Enter your first name: ");
String firstName = input.nextLine();

System.out.print("Enter your last name: ");
String lastName = input.nextLine();

Login user = new Login(firstName, lastName);
System.out.print("Create a username (must have _ and <=5 chars): ");
String username = input.nextLine();
System.out.print("Create a password (8 chars, Caps, number, special): ");
String password = input.nextLine();
System.out.print("Enter your South African cell number (+27...): ");
String cellPhoneNumber = input.nextLine();
String registrationMessage = user.registerUser(username, password, cellPhoneNumber);
System.out.println("\n" + registrationMessage);
if (registrationMessage.equals("User registered successfully.")) {
System.out.println("\n---------- Login ----------");
System.out.print("Enter username: ");
String loginUsername = input.nextLine();
System.out.print("Enter password: ");
String loginPassword = input.nextLine();
System.out.println(user.returnLoginStatus(loginUsername, loginPassword));
}
input.close();
}
}
