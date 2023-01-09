import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 
 * Logs the user in the application
 * @author PushnPop
 * @version 1.0
 *
 */


public class LoginFinal {

	
	Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    /** 
     * Public Constructor
     * Creates an object of class SQLiteConnectionB
     * @param conn Connects with database
     * 
     * */
    public LoginFinal() {
    	conn = SQLiteConnectionB.ConnectDb();
    }
    
    /**
     * Authenticates the user and does the Login
     * @return a boolean value of whether or not the Login was successful
     * */
    @SuppressWarnings("deprecation")
	public boolean logTheUser(JTextField userTextField, JPasswordField passwordField) {
    	
    	String sql = "SELECT * from Users WHERE username LIKE ? AND password LIKE ?; ";
    	
    	try {
    		pst = conn.prepareStatement(sql); // connects with database
    		
        	pst.setString(1, userTextField.getText()); 
        	pst.setString(2, passwordField.getText());
    		
        	rs = pst.executeQuery(); // executes the sql query
        	
        	/*if the query is executed successfully displays message of login
        	else, displays message of invalid credentials*/
        	if(rs.next()) {
        		JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULL");
        		
        		  pst.close();
              	  rs.close();
                  return true;       		
        	} else {
        		JOptionPane.showMessageDialog(null, "Invalid Username or Password. Try again!");
        		return false;
        	}
        	
 
    		
    	} catch (Exception e1) {
    		return false;
    	} 
    }
    

}
