import java.sql.ResultSet;
import java.sql.Statement;

public class Like {

	private String username;
	private String msg;

	public Like(String username, String msg) {
		this.username = username;
		this.msg = msg;

	}
	/* σε περίπτωση που ο χρήστης δηλώσει πως θέλει να κάνει λαικ(κουμπί ή πληκτρολόγηση), η μειν καλεί τη λαικ στέλνοντάς της το ποστ το οποίο
	 * επέλεξε ο χρήστης καθώς και τη θέση του στη βάση. αυτή καταχωρεί το λαικ, αυξάνοντας τον αριθμό των λαικς που έχει το ποστ κατα 1.
	 */

    public int countLike(String msg) {
		ResultSet resultset = null;

	    String selectSql = " SELECT like_id , msg_id from Collife.Like where msg_id = msg";
	    resultSet = statement.executeQuery(selectSql);

	    int count = 0;
	    while ( resultSet.next()) {
		      count++;
	    }
        return count;
	}
}