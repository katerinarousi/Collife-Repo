package collifePckg;
//package : ex1

import java.util.Scanner;
public class SignIn {

	
	//��� �� ���� � ������� ����������� ���� ���� ���� ���� ��� �� �� �� ������
	public static void main(String[] args) {
		
		
		System.out.println("Welcome to our Student Net! Please choose a unique username and a password");
		
		Scanner i = new Scanner(System.in);
	
		boolean check = true;
		while(check) {
			
			
			String username = i.nextLine();
			/*��� �� ������� ���� �������� �� ����������� ��� �� ����� �� ������� ��� ��� ����*/
			
			
		}
	
		/*do {
			String username = i.nextLine();
		

		} while; //������� ��� ������������, ������ ��� ����
		 	*/
		boolean flag = true;
		System.out.println("test1");
		while (flag){
			System.out.println("test2");

			String password = i.nextLine();
			System.out.println("test3");

			int pasLength = password.length();
			System.out.println(pasLength);
		
			if (pasLength > 8) {
				if (password.contains("!") || password.contains("#") || password.contains("$") || password.contains("%") || password.contains("^") || password.contains("&") || password.contains("*")) {
					if (password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") || password.contains("5") || password.contains("6") || password.contains("7") || password.contains("8") || password.contains("9") ) {
						System.out.println("test4");

						flag = false;
						System.out.println("Nice! Your password is secure!");
						// kai alla pragmata
					}
				}
			}else {
				System.out.println("oops! your password is not secure. please try again.");
			}
			System.out.println("test5");

			
			i.close();
		
	
	
	
	
	
		}
	}
}

