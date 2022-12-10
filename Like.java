import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Like {
	//count LIKE

	private String url = "C:\\Users\\paras\\eclipse-workspace\\SQLiteConnection\\cc_db.db\\";
	Connection connection = null;
	 PreparedStatement state = null;
		    public void InsertLike(int likeid,String name,int msgid) {
				String insertSql = "INSERT INTO Likes (like_id,username,msg_id) VALUES ( " + likeid + " ," + name + "," + msgid + ");";
			    ResultSet resultSet = null;
			    try {
				  connection = DriverManager.getConnection(url);
				  state =connection.prepareStatement(insertSql);

				  state.execute();

		        } catch (Exception e) {
				  e.printStackTrace();
			    }
	}

	public int countLike(int msgid) {
					String sSql = " SELECT * FROM Likes WHERE msg_id  LIKE ?; ";
				    ResultSet resultSet = null;
				    try {
					  connection = DriverManager.getConnection(url);
					  state =connection.prepareStatement(sSql);
					  resultSet = state.executeQuery(sSql);

					  int count = 0;
					  	    //count like and print
					  	    while (resultSet.next()) {
					  			count++;
					  			System.out.println(resultSet.getInt("like_id"));
					  			System.out.println(resultSet.getInt("msg_id"));

					  		}
                      return count;

			        } catch (Exception e) {
					  e.printStackTrace();
					  return -1;
				    }

	}
}