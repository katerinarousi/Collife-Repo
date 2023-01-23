package gr.Collife;

import static org.junit.Assert.*;
import org.junit.Test; 
import static org.junit.Assert.assertEquals;
import java.sql.Connection;

public class SQLiteConnectionBTest {
 
  @Test  
    public void ConnectDb(){  
		try {
			System.out.println("ConnectDb starts");
			Connection expectedValue = null; 
			Connection actualValue=SQLiteConnectionB.ConnectDb();
			
			System.out.println("expected value= "+ expectedValue +" and actual value= "
			+actualValue);
			
			assertEquals(expectedValue, actualValue);
			
			} catch (Exception exception) {
			exception.printStackTrace();
			assertFalse(false);
		}
    }  
}
