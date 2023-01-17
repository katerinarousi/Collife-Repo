package PushnPop;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidateFinalTest {

    @Test
    public void testValidUsername() {
        String validUsername = "validUsername";
        boolean result = ValidateFinal.isValidUsername(validUsername);
        assertTrue(result);
    }

    
    @Test
    public void testUsernameTooShort() {
        String shortUsername = "aB1";
        boolean result = ValidateFinal.isValidUsername(shortUsername);
        assertFalse(result);
    }

    @Test
    public void testUsernameTooLong() {
        String longUsername = "aB1abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        boolean result = ValidateFinal.isValidUsername(longUsername);
        assertFalse(result);
    }

    @Test
    public void testUsernameStartsWithNumber() {
        String usernameStartsWithNumber = "1InvalidUsername";
        boolean result = ValidateFinal.isValidUsername(usernameStartsWithNumber);
        assertFalse(result);
    }
}