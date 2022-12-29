import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInB {
	
		Connection conn = null;
	    PreparedStatement pst = null;
	    ResultSet rs = null;
	
	public SignInB() {
		conn = SQLiteConnectionB.ConnectDb();
	}
	
	public void signTheUser(JTextField userTextField, JPasswordField passwordField ) {
		
        String sql = "INSERT INTO Users(username,password) VALUES (?,?)";
       
        try {
        	pst = conn.prepareStatement(sql);
        	pst.setString(1, userTextField.getText());
        	pst.setString(2, passwordField.getText());
        	
        	pst.execute();
        	System.out.println("inserted into users");
      // CHECK IF USERNAME ALREADY EXISTS //        	
        	    if (CheckU.CheckIfExists(userTextField.getText()) == true) {
        		    JOptionPane.showMessageDialog(null, "Username already exists! Try again!");	
        	    }        	
      // VALIDATE USERNAME USING REGULAR EXPRESSION //	
        	
        	
        	if (userTextField.getText() != null) {
        		if (ValidateU.isValidUsername(userTextField.getText()) == false) {
            		JOptionPane.showMessageDialog(null, "Username invalid");
            	}            	
        	}
        	
        	JOptionPane.showMessageDialog(null, "Registration successfull");
        	
        	
        	pst.close();
        		
        	
        }catch (Exception e1){
        	JOptionPane.showMessageDialog(null, e1);
        	System.out.println("Registration NOT");
        	
        }
        userTextField.setText("");
        passwordField.setText("");
        
       
        }
	}


