import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Message {

	private String url = "C:\\Users\\paras\\eclipse-workspace\\SQLiteConnection\\cc_db.db\\";
    public void InsertMess(int id,String name,String des,int category) {
		String insertSql = "INSERT INTO Message (msg_id,username,description,category_id) VALUES ( " + id + " ," + name + "," + des + "," + category + ");";
	    ResultSet resultSet = null;
	    try {
		  Connection connection = DriverManager.getConnection(url);
		  PreparedStatement state =connection.prepareStatement(insertSql);

		  state.execute();

        } catch (Exception e) {
		  e.printStackTrace();
	    }
	}
}
