package PushnPop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Function to validate the username//

public class ValidateFinal {
	
	
    
    
  public static boolean isValidUsername(String username) {
    //Regex to check valid username//
	
    String regex = "^[A-Za-z]\\w{5,29}$";
    
    // Compile the ReGex
    Pattern p = Pattern.compile(regex);

  

    // Pattern class contains matcher() method
    // to find matching between given username
    // and regular expression.
    Matcher m = p.matcher(username);

    // Return if the username
    // matched the ReGex
    return m.matches();
  }

}