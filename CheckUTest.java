import static org.junit.Assert.*;				
import org.junit.Test;	

public class ChechUTest {

    CheckU user = new CheckU(); 
    
    @Test
    public void CheckIfExistsTest () {
        //πρωτη εγγραφη 
        SignInFinal user2 = new SignInfinal();
        user2.signTheUser(test_username,1234567);
        boolean result1 = user2.CheckIfExists(test_username);
        if (result1 == false) 
            //δευτερη εγγραφη με το ιδιο ονομα 
            user2.signTheUser(test_username, 567827); //μπαινει δευτερη φορα στη βάση?
            boolean result2 = user.CheckIfExists(test_username);
            assertNotEquals(result1, result2);
            //πρεπει πρωτο false , δευτερο true

        } 

 
    @Test //αυτοματοποιήμενο
    public void CheckIfExistsTest3() {
        assertEquals(false, checkU.CheckIfExists("test_username2"));
    }
}

