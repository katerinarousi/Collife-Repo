
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckU {
	
    static Connection conn= null;
    PreparedStatement pst = null;
    
    
    
    
    public CheckU() {
    	
    	conn = SQLiteConnectionB.ConnectDb();
    }
    
	public static boolean CheckIfExists (String username) 
	{
		
		boolean usernameExists = false;
		
		try
		{
			PreparedStatement pst = conn.prepareStatement("SELECT * FROM Users order by username desc");
	        ResultSet r1 = pst.executeQuery();
	        
	        String usernameCounter;
	        
	         if(r1.next()) 
	         { 
	        	 usernameCounter =  r1.getString("username");
	        	 if(usernameCounter.equals(username)) {
	        		 usernameExists = true;
	        		 
	        	 }
	        	 	        	 
	         }
		} 
	      catch (SQLException e) 
	    {
	            
	    } 

	     return usernameExists;
	        
			
	}
}