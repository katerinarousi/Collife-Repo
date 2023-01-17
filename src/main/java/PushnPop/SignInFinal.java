package PushnPop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.sqlite.SQLiteException;

public class SignInFinal {
  // initialize connection object
  Connection conn;
  // initialize PreparedStatement onject
  PreparedStatement pst;
  // initialize ResultSet object
  ResultSet rs;

  public SignInFinal() {
    // create database object
    conn = SQLiteConnectionB.ConnectDb();
  }
    
  /* method that accepts the username and the password 
   * and signs in the user */
	
  public void signTheUser(JTextField userTextField, JPasswordField passwordField) {
	
    String sql = "INSERT INTO Users(username,password) VALUES (?,?)";
   
    try {
      pst = conn.prepareStatement(sql);
      pst.setString(1, userTextField.getText());
      pst.setString(2, passwordField.getText());
      try {
	    // executes the pst
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
       // Message with the correct way to write the username correct
          JOptionPane.showMessageDialog(null, "Username invalid. \n Must consist of 6 to 30 characters inclusive. \n It can only contain alphanumeric characters and underscores (_).\n"
              + "The first character of the username must be an alphabetic character, i.e., either lowercase character\r\n"
          	+ "[a – z] or uppercase character [A – Z].");
        }
      }
    	
   // Close the connection
      pst.close();
    	
    	
    } catch (Exception e1) {
      JOptionPane.showMessageDialog(null, e1);
      System.out.println("Registration NOT");
    	
    }
	// Sets the TextFiled back to blank
	
    userTextField.setText("");
    passwordField.setText("");
    
   
  }
}
