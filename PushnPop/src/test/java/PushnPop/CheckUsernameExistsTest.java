package PushnPop;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CheckUsernameExistsTest {
    @Test
    public void testCheckIfExists() {
        CheckUsernameExists check = new CheckUsernameExists();
        boolean actual = check.CheckIfExists("usernotregistered");
        boolean expected = false; //no saved in our database
        assertEquals(expected, actual);
    }
}
