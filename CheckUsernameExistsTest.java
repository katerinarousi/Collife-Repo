package gr.Collife;

import static org.junit.Assert.*;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CheckUsernameExistsTest {

 
  @Test  
    public void CheckIfExists(){  
		try {
			System.out.println("CheckIfExists starts");
			
			boolean expectedV = false; 
			String username = "";
			boolean actualV = CheckUsernameExists.CheckIfExists(username);
			
			System.out.println("expected value= "+ expectedV +"and actual Value= "
			+actualV);
			
			assertEquals(expectedV, actualV);
			
		} catch (Exception exception) {
			
			exception.printStackTrace();
			assertFalse(false);
		}
    }  
}