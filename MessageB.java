import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class MessageB {

	Connection conn = null;
	PreparedStatement state = null;

    public String getMessage(ArrayList<String> i) {
		return i.get(i.size());
	}

	public String getID(int count ,String category) {
		String myID;
		count--;
		switch (category) {
			case "GENERAL":
			   myID = "1." + count;
               break;
			case "VOLUNTEER":
			   myID = "2." + count;
               break;
			case "NIGHTLIFE":
			   myID =  "3." + count;
               break;
			case "TRAVEL":
               myID =  "4." + count;
			   break;
			case "FOOD":
			   myID =  "5." + count;
               break;
            case "UNIVERSITY":
			   myID = "6." + count;
               break;
			default:
			   myID =  "-1";

		 }
		 return myID;
	 }



    public void insertMessage(String id,String name,String des,String category) throws SQLException {
		String insertSql = "INSERT INTO Message (msg_id,username,description,category_id) "
				+ "VALUES (?,?,?,?);";
		
		PreparedStatement state = conn.prepareStatement(insertSql);
		
		state.setString(1, id);
		state.setString(2, name);
		state.setString(3, des);
		state.setString(1, category);
	   
		ResultSet resultSet = null;
	    try {
		  conn = SQLiteConnectionB.ConnectDb();
		  state =conn.prepareStatement(insertSql);

		  state.executeQuery();

        } catch (Exception e) {
		  e.printStackTrace();
	    }
	}
}
