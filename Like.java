package collifePckg;

public class Like extends Action {
	
	//πρέπει κάπως να τη σχετίσω με το ποστ. 
	//μήπως να κάνει εξτεντ την ποστ αντί για την ακσιον? 
	//μήπως τελικά δεν χρειάζεται άξιον μέθοδος και είναι μη λειτουργική ή και περιττή?
	
	
	private String username;
	private String post;
	private String position;
	private int countLikes; 
	
	public Like(String username, String post, String position) {
		super(username);
		this.post = post;
		this.position = position;
	
	}
	/* σε περίπτωση που ο χρήστης δηλώσει πως θέλει να κάνει λαικ(κουμπί ή πληκτρολόγηση), η μειν καλεί τη λαικ στέλνοντάς της το ποστ το οποίο
	 * επέλεξε ο χρήστης καθώς και τη θέση του στη βάση. αυτή καταχωρεί το λαικ, αυξάνοντας τον αριθμό των λαικς που έχει το ποστ κατα 1.
	 */
	public String getUsername() {
		super.getUsername();
	}
	
	public String getPosition() {
		return position;
	}
	
	public int countLikes() {
		
		countLikes++;
		return countLikes;
		
	}
}
