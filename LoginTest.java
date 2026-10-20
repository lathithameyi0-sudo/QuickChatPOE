import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class LoginTest {
@Test public void testUsernameCorrectlyFormatted() {
Login user = new Login("Lathitha", "Meyi");
assertTrue(user.checkUserName("kyl_1"));
}
@Test public void testUsernameIncorrectlyFormatted() {
Login user = new Login("Lathitha", "Meyi");
assertFalse(user.checkUserName("kyle!!!!!!!"));
}
@Test public void testPasswordMeetsComplexityRequirements() {
Login user = new Login("Lathitha", "Meyi");
assertTrue(user.checkPasswordComplexity("Ch&&sec@ke99!"));
}
@Test public void testPasswordDoesNotMeetComplexityRequirements() {
Login user = new Login("Lathitha", "Meyi");
assertFalse(user.checkPasswordComplexity("password"));
}
@Test public void testCellPhoneCorrectlyFormatted() {
Login user = new Login("Lathitha", "Meyi");
assertTrue(user.checkCellPhoneNumber("+27838968976"));
}
@Test public void testCellPhoneIncorrectlyFormatted() {
Login user = new Login("Lathitha", "Meyi");
assertFalse(user.checkCellPhoneNumber("08966553"));
}
}

