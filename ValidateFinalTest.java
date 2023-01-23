package gr.Collife;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidateFinalTest {

    ValidateFinal validateUsername = new ValidateFinal();

    @Test
    public void testValidUsername() {
        boolean isValid = validateUsername.isValidUsername("valid_username");
        assertEquals(true, isValid);
    }

    @Test
    public void testInvalidUsernameWithTooShort() {
        boolean isValid = validateUsername.isValidUsername("short");
        assertEquals(false, isValid);
    }

    @Test
    public void testInvalidUsernameWithTooLong() {
        boolean isValid = validateUsername.isValidUsername("this_username_is_way_too_long_to_be_valid");
        assertEquals(false, isValid);
    } 

    @Test
    public void testInvalidUsernameStartsWithNumber() {
        boolean isValid = validateUsername.isValidUsername("1st_invalid_username");
        assertEquals(false, isValid);
    }
    
    @Test
    public void testInvalidUsernameWithSpecialCharacters() {
        boolean isValid = validateUsername.isValidUsername("invalid@username");
        assertEquals(false, isValid);
    }
}