import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Message {

	Connection connection = null;
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



    public void insertMessage(String id,String name,String des,String category) {
		String insertSql = "INSERT INTO Message (msg_id,username,description,category_id) VALUES ( " + id + " ," + name + "," + des + "," + category + ");";
	    ResultSet resultSet = null;
	    try {
		  connection = SQLiteConnection.ConnectDb();
		  state =connection.prepareStatement(insertSql);

		  state.execute();

        } catch (Exception e) {
		  e.printStackTrace();
	    }
	}
}
