import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFinal {

	Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public LoginFinal() {
    	conn = SQLiteConnectionB.ConnectDb();
    }
    
    @SuppressWarnings("deprecation")
	public boolean logTheUser(JTextField userTextField, JPasswordField passwordField) {
    	
    	String sql = "SELECT * from Users WHERE username LIKE ? AND password LIKE ?; ";
    	
    	try {
    		pst = conn.prepareStatement(sql);
    		System.out.println("into users");
    		
        	pst.setString(1, userTextField.getText());
        	pst.setString(2, passwordField.getText());
    		
        	rs = pst.executeQuery();
        	
        	if(rs.next()) {
        		JOptionPane.showMessageDialog(null,"LOGIN SUCCESSFULL");
        		
        		  new MenuBarFinal(new MenuFrameFinal(userTextField.getText()));
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
