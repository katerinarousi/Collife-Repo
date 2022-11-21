import java.io.PrintWriter;
import java.util.Scanner;

public class Singin {

	Scanner input = new Scanner(System.in);

	public String username(){

    	System.out.println("Username: "); //creates username ..... must be stored in database
    	String accName = input.nextLine();

    	/*FileWriter fw = null;
    	BufferedWriter bw = null;
    	PrintWriter pw = null;

    	fw = new FileWriter("Unilink.txt",true);
    	bw = new BufferedWriter(fw);
    	pw = new PrintWriter(bw);

    	pw.println("accName");
    	pw.flush();*/


    	return accName;
	}

	public String department(){

    	System.out.println("Department:"); //creates department ..... must be stored in database
    	String dept = input.nextLine();
    	return dept;
	}

	public String password(){

		String accPin3;
		String accPin;

    	boolean isdone = false;
    	do {
    	   System.out.println("Password : "); //creates and checks password ..... must be stored in database
    	    accPin = input.nextLine();
    	    if (isStrong(accPin) == true) {
    	        System.out.println("Password is Strong");
    	        System.out.println("Please enter the password again to confirm");
    	        String accPin2 = input.nextLine();
    	            if (accPin2.equals(accPin)) {
    	                System.out.println("Your account is set!");
    	                isdone = true;
    	                break;
    	            } else {
    	                do {
    	                    System.out.println("The password entered here is invalid");
    	                     System.out.println("Please re-enter the password to confirm : ");
    	                     accPin3 = input.nextLine();
    	                 } while (accPin3.equals(accPin));
    	            }
    	    } else {
    	        System.out.println("Password is weak :( Try again with a strongest password");
    	    }
    	} while (!isdone);

		return accPin;
	}

    public  boolean isStrong(String password) { //checks password, returns true or false. prerequisites: over 7 digits, at least an Uppercase and a lowercase char, at least a number, at least a special char

            boolean isValid = true;
            if (password.length() < 8)
            {
                    System.out.println("Password must be at least 8 digits in length.");
                    isValid = false;
            }
            final String upperCaseChars = "(.*[A-Z].*)";
            if (!password.matches(upperCaseChars))
            {
                    System.out.println("Password must have at least one uppercase character");
                    isValid = false;
            }
            final String lowerCaseChars = "(.*[a-z].*)";
            if (!password.matches(lowerCaseChars))
            {
                    System.out.println("Password must have atleast one lowercase character");
                    isValid = false;
            }
            final String numbers = "(.*[0-9].*)";
            if (!password.matches(numbers))
            {
                    System.out.println("Password must have atleast one number");
                    isValid = false;
            }
            final String specialChars = "(.*[@,#,$,%].*$)";
            if (!password.matches(specialChars))
            {
                     System.out.println("Password must have atleast one special character among @#$%");
                            isValid = false;
            }
            return isValid;
    }
}






