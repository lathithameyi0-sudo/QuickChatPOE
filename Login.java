public class Login {

private String firstName;
private String lastName;
private String username;
private String password;
private String cellPhoneNumber;

public Login(String firstName, String lastName) {
this.firstName = firstName;
this.lastName = lastName;
}
public boolean checkUserName(String username) {
return username != null && username.length() <= 5 && username.contains("_");
}
public boolean checkPasswordComplexity(String password) {
if (password == null || password.length() < 8) return false;
boolean hasCapital = false, hasNumber = false, hasSpecial = false;
for (int i = 0; i < password.length(); i++) {
char c = password.charAt(i);
if (Character.isUpperCase(c)) hasCapital = true;
else if (Character.isDigit(c)) hasNumber = true;
else if (!Character.isLetterOrDigit(c)) hasSpecial = true;
}
return hasCapital && hasNumber && hasSpecial;
}
public boolean checkCellPhoneNumber(String cellPhoneNumber) {
if (cellPhoneNumber == null) return false;
return cellPhoneNumber.matches("^\\+27[6-8][0-9]{8}$");
}
public String registerUser(String username, String password, String cellPhoneNumber) {
if (!checkUserName(username)) {
return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
}
if (!checkPasswordComplexity(password)) {
return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
}
if (!checkCellPhoneNumber(cellPhoneNumber)) {
return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
}
this.username = username;
this.password = password;
this.cellPhoneNumber = cellPhoneNumber;
return "User registered successfully.";
}
public boolean loginUser(String username, String password) {
return this.username != null && this.password != null && this.username.equals(username) && this.password.equals(password);
}
public String returnLoginStatus(String username, String password) {
if (loginUser(username, password)) {
return "Welcome " + firstName + " " + lastName + ", it is great to see you.";
}
return "Username or password is incorrect, please try again.";
}
}
