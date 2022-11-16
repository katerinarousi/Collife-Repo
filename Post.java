package collifePckg;


public class Post extends Action {
	
	//System.out.println("Share your thoughts with your community!");
	//αυτό λογικά θα μπει στη main μαζί με ένα σκανεράκι, η οποία θα δημιουργεί αντικείμενο και θα καλεί την ποστ.
	//επίσης, η ποστ θα αποθηκεύει το μήνυμα στη βάση αφού τη φτιάξουμε.
	
	private String message;
	private String dom; //date of message
	
	public Post(String username, String message) {
		super(username);
		this.message = message;
	}
	
	public String getUsername() {
		super.getUsername();
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getDom() {
		return dom;
	}
	
	
	
	
	
	
	
	
	

}
