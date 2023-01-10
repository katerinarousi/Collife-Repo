import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidateUsernameTest {

    ValidateU ValidateUsername = new ValidateU();

    @Test
    public void testValidUsername() {
        boolean isValid = ValidateUsername.isValidUsername("valid_username");
        assertEquals(true, isValid);
    }

    @Test
    public void testInvalidUsernameWithTooShort() {
        boolean isValid = ValidateUsername.isValidUsername("short");
        assertEquals(false, isValid);
    }

    @Test
    public void testInvalidUsernameWithTooLong() {
        boolean isValid = ValidateUsername.isValidUsername("this_username_is_way_too_long_to_be_valid");
        assertEquals(false, isValid);
    } 

    @Test
    public void testInvalidUsernameStartsWithNumber() {
        boolean isValid = ValidateUsername.isValidUsername("1st_invalid_username");
        assertEquals(false, isValid);
    }
    
    @Test
    public void testInvalidUsernameWithSpecialCharacters() {
        boolean isValid = ValidateUsername.isValidUsername("invalid@username");
        assertEquals(false, isValid);
    }
}