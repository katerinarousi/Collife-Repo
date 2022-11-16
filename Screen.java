package collifePckg;
import java.util.*;

public class Screen {

	/* �������� ���� ��� POSTS/MESSAGES ��� �� ����*/
	//erwthsh: theloume to username or not?
	//logika tha kaleitai apo thn klash h opoia tha exei th main

	public void introScreen() {

		System.out.println("Welcome to Collife, a network that connects students! Please choose category");

		System.out.println("1. General");
		System.out.println("2. Lifestyle");
		System.out.println("3. Uni");
		System.out.println("4. Travel");
		System.out.println("5. Sports");
		System.out.println("6. Food");
		System.out.println("7. Chat");

		Scanner input = new Scanner(System.in);
		int ans = input.nextInt();

		switch (ans) {
		case 1:
			generalScreen();
			break;
		case 2:
			lifestyleScreen();
			break;
		case 3:
			uniScreen();
			break;
		case 4:
			travelScreen();
			break;
		case 5:
			sportsScreen();
			break;
		case 6:
			foodScreen();
			break;
		case 7:
			chatScreen();
			break;
		default:
			System.out.println("please choose a valid category");
		}
	}

	public void generalScreen() {

		System.out.println("Welcome to our general category. Here you can post anything you' d like to share with the student community.");
		
		System.out.println("Select 1 to see old posts or 2 to make a new one");
		
		int a = input.nextInt();
		
		if (a==1) {
			System.out.println("emfanizei ta posts. vash?");
			
		}else {
			System.out.println("share your thoughts");
			
		}
		
		


			/* ��� ������������ �� posts ��� ���������� general*/

			//an kapoios thelei na kanei post kanei klhsh ths post
			//same me tis epomenes methodous
	}

	public void lifestyleScreen() {

		System.out.println("Welcome to our lifestyle category. Here you can post all things related to the student lifestyle. Be creative!");

	}

	public void uniScreen() {

		System.out.println("Welcome to our Uni category. Here you can post all things related with your everyday university life.");

	}

	public void travelScreen() {

		System.out.println("Welcome to our Travel category. Qs and As for all your travel worries!");

	}

	public void sportsScreen() {

		System.out.println("Welcome to our sports category. Here you can post things about all your favorite sports and athletes. Be respectful!");

	}

	public void foodScreen() {

		System.out.println("Welcome to our foods category. Here you can post everything about food");

	}

	public void chatScreen() {

		System.out.println("Welcome to our all-inclusive chatroom! Here you can talk freely with other students about anything imaginable. Have fun!");

	}

}
