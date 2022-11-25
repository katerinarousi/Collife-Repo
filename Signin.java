public class Singin {


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






