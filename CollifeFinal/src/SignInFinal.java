import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

	public class SignInFinal {

		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

    public SignInFinal() {
	    
    // create database object 
	    
	    
    	conn = SQLiteConnectionB.ConnectDb();
    }

    public void signTheUser(JTextField userTextField, JPasswordField passwordField ) {
	
    	String sql = "INSERT INTO Users(username,password) VALUES (?,?)";
   
    	try {
    		pst = conn.prepareStatement(sql);
    		pst.setString(1, userTextField.getText());
    		pst.setString(2, passwordField.getText());
        	
    	  
		try {	
    		pst.execute();
    		System.out.println("inserted into users");
			
			
  // Check if username already exists  
			
			
    	        CheckUsernameExists.CheckIfExists(userTextField.getText());
                     	
                } catch (NullPointerException e1) {
        	
                } catch (SQLiteException e2) {
   		    JOptionPane.showMessageDialog(null, "Username already exists.Try again.");
   		    
   		 		   
                }
		
  // Validate username with regular expression	
    	
    	
    		
    		if (userTextField.getText() != null) {
    			if (ValidateFinal.isValidUsername(userTextField.getText()) == false) {
    				JOptionPane.showMessageDialog(null, "Username invalid. \n Must consist of 6 to 30 characters inclusive. \n It can only contain alphanumeric characters and underscores (_).\n"
          	+ "The first character of the username must be an alphabetic character, i.e., either lowercase character\r\n"
          	+ "[a – z] or uppercase character [A – Z].");
    			}            	
    		}
    	
    		
    	
    		pst.close();
    		
    	
    	}catch (Exception e1){
    		JOptionPane.showMessageDialog(null, e1);
    		System.out.println("Registration NOT");
    	
    	}
    	userTextField.setText("");
    	passwordField.setText("");
    
   
    }
}
