import static org.junit.Assert.*;				
import org.junit.Test;	

public class UserTest {

    static User user = new User();

    @Before 
    public static void setupClass() {
        user.setUsername("alkistis");
        user.setPassword("123aset");
        user.setUni("opa");
    }

    @Test
     void getUsernameTest() {
    // compare expected value with actuall one --> all getters

        String expected = "alkistis";
        String actual = user.getUsername();
        asserEquals(expected, actual);


    }

    @Test
    public void getPaswordTest() {
    // compare expected value with actuall one --> all getters

        String expected = "123aset";
        String actual = user.getPassword();
        asserEquals(expected, actual);
        

    }

    @Test
    public void getUniTest() {
    // compare expected value with actuall one --> all getters

        String expected = "opa";
        String actual = user.getUni();
        asserEquals(expected, actual);
        

    }
}
