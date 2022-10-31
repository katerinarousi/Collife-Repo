import java.util.*;
import java.util.ArrayList; // import the ArrayList class
public class Main {

   private static final Map<String, Account> accounts = new HashMap<>();//
    private static final ArrayList<String> mess = new ArrayList<String>();

    public static void main(String[] args) {

        while (true) {
			System.out.println();
			System.out.println("MAIN MENU");
            System.out.println("Choose an option:");
            System.out.println("1 - Create new account");
            System.out.println("2 - Login into an account");
            System.out.println("3 - List account numbers");
            System.out.println("4 - Quit");
            System.out.println();
            Scanner input = new Scanner(System.in);
            int ch = input.nextInt();

            if (ch == 1) {
                createAccount();
            } else if (ch == 2) {
                login();
            } else if (ch == 3) {
                listAccountNumbers();
            } else if (ch == 4) {
                break;
            } else {
                System.out.println("Invalid number");
            }
        }

    }
private static void createAccount() {
        System.out.println("Username: ");
        Scanner input = new Scanner(System.in);
        String accName = input.nextLine();
        System.out.println("Password (4 digit pin): ");
        Scanner input2 = new Scanner(System.in);
        int accPin = input2.nextInt();

        Account account = new Account(accName, accPin);

       accounts.put(accName, account);
    }






    private static void login() {
        System.out.println("Enter your username: ");
        Scanner input1 = new Scanner(System.in);
        String accNameInput= input1.nextLine();
        System.out.println("Enter your password: ");
        Scanner input2= new Scanner(System.in);
        int accPinInput = input2.nextInt();

        Account account = accounts.get(accNameInput);
        if(account.getPin() == accPinInput) {
            System.out.println("Valid credentials for account number " + account.getName());

            System.out.println("Write your message (M for main menu )");

            Scanner input3 = new Scanner(System.in);
			String s=input3.nextLine();
			String ss=account.getName()+ ": " + s+" ";
        	System.out.print(ss);
        	System.out.println();
        	while(true) {
				//Scanner input4 = new Scanner(System.in);
				String s2=input3.nextLine();
				String ss2=account.getName()+ ": " + s2+" ";
        		System.out.print(ss2);
        		System.out.println();

        		if (s2.equals("m"))
					break;
	}
        } else {
            System.out.print("Invalid credentials for account username: " + account.getName());
        }
    }

    private static void listAccountNumbers() {
        accounts.keySet().forEach(System.out::println);
    }

}

