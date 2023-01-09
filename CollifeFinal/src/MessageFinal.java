import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JTextPane;

/**
 * Connects with database and selects/inserts messages
 * @author PushnPop
 * @version 1.0
 * 
 */
public class MessageFinal {
	
	static Connection conn = null;
	static PreparedStatement state = null;
	static ResultSet rs;
	ArrayList<String> a = new ArrayList<>();

    public String getMessage(ArrayList<String> i) {
		return i.get(i.size());
	}
    
    /**
     * creates the message id that the database uses connecting the identification number with the category number
     * @param count An int that represents the identification number
     * @param category A String value that represents the category the user is writing in
     * @return myID A String value that represents the final ID of the message that goes into the database
     * 
     * */
	public String getID(int count ,String category) {
		String myID;
		count--;
		System.out.println(count);
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
	
	/**
	 * 
	 * Connects with the database and inserts the new messages from the user
	 * @param id A String value that represents the message id
	 * @param name A String value that represents the username
	 * @param cont A String value that represents the contents of the message
	 * @param category A String value that represents the category the user is in
	 * @throws SQLException
	 * 
	 * */
    public void insertMessage(String id, String name, String cont, String category) throws SQLException {
		
    	String insertSql = "INSERT INTO Message (msg_id, username, description, category) "
				+ "VALUES (?,?,?,?);";
		conn = SQLiteConnectionB.ConnectDb();
		PreparedStatement pst = conn.prepareStatement(insertSql);
		pst.setString(1, id);
		pst.setString(2, name);
		pst.setString(3, cont);
		pst.setString(4, category);
			   
	    try {
		  pst.execute();
        } catch (Exception e) {
		  e.printStackTrace();
	    }
	    pst.close();
	}
    
    
    /**
     * 
     * Connects with the database and displays all previous messages
     * @param category A String value that represents the category that the user is in
     * 
     * */
	public void selectmessage(String category) {
		
		String sql = " SELECT * FROM Message WHERE category = ?;";
		try {
			conn = SQLiteConnectionB.ConnectDb();
			state= conn.prepareStatement(sql);
			state.setString(1, category);
			rs = state.executeQuery();
        
			while(rs.next()) {    	
				String msg = rs.getString("description");
				a.add(msg);
			}
						
			ChatFrameFinal.showMess.setText(a.toString().replaceAll("[\\[\\]//,]", ""));			
			state.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
    	}
	}

	/**
	 * 
	 * Returns the last identification number from the given category
	 * @param a An ArrayList of type String that contains the ids fetched from the database
	 * @param top A String value that represents the code of the given category 
	 * @return returns A String value that represents the last identification number from the given category
	 * 
	 * */
	
	public static String getMax(ArrayList<String> a, String top) {
		
		int[] intFirsts = new int[a.size()];	
		int[] intSeconds = new int[a.size()];
		String[] temp = new String[a.size()];
		
		for (int i = 0; i < a.size(); i++) {
			
			intFirsts[i] = Integer.parseInt(a.get(i).substring(0,1));
			temp[i] = a.get(i).substring(2);
			intSeconds[i] = Integer.parseInt(temp[i]);			
		}
		
		int i = 0;		
		while(i < intFirsts.length && intFirsts[i] < Integer.parseInt(top) ) {
			i++;
		}			
		int maxp = i++;
		while (i < intFirsts.length && intFirsts[i] == Integer.parseInt(top) ) {
			if (intSeconds[i] > intSeconds[maxp]) {
				maxp = i;

			}
			i++;			
		}
		
		String returns = String.valueOf(intSeconds[maxp]);
		return returns;
				
	}
	
	/**
	 * 
	 * Connects with the database and returns the last entry (id) for each category
	 * @return lastRows An int array of 6 that consists of the last id that is inserted into the database for each category
	 * @throws SQLException
	 * 
	 * */
	public static int[] getLastRows() throws SQLException {
		
		String myLastRow = "SELECT msg_id FROM Message";
		
		conn = SQLiteConnectionB.ConnectDb();
		state = conn.prepareStatement(myLastRow);
		rs = state.executeQuery();
		ArrayList<String> a = new ArrayList<>();
		

		while(rs.next()) {
			
			a.add(rs.getString("msg_id"));
			
		}
		state.close();
		rs.close();
		conn.close();
		
		
		
		int i;
		int c = 0;
		int[] lastRows = new int[6];
		
		for(int b =0; b  < a.size(); b++ ) {
			System.out.println(a.get(b));
		}  
		
		boolean check1 = false;
		boolean check2 = false;
		boolean check3 = false;
		boolean check4 = false;
		boolean check5 = false;
		boolean check6 = false; 
		String cases;
		
		for (i = (a.size() - 1); i > 0; i--) {

			switch (a.get(i).substring(0,1)) {
			case  "1":
				cases = "1";
				if (check1 == false) {
						
					lastRows[0] = Integer.parseInt(getMax(a, cases));			
					check1 = true;
					c++;
				}
				break;
			case "2":
				cases = "2";

				if (check2 == false) {
					
					lastRows[1] = Integer.parseInt(getMax(a, cases));					
					check2 = true;
					c++;
				}
				break;
				
			case "3":
				cases = "3";

				if (check3 == false) {					
					lastRows[2] = Integer.parseInt(getMax(a, cases));					
					check3 = true;
					c++;
				}
				break;
				
			case "4":
				cases = "4";

				if (check4 == false) {					
					lastRows[3] = Integer.parseInt(getMax(a, cases));					
					check4 = true;
					c++;
				}
				break;
				
			case "5":
				cases = "5";

				if (check5 == false) {					
					lastRows[4] = Integer.parseInt(getMax(a, cases));
					
					check5 = true;
					c++;
				}
				break;
				
			case "6":
				cases = "6";
				if (check6 == false) {					
					lastRows[5] = Integer.parseInt(getMax(a, cases));					
					check6 = true;
					c++;
				}
				break;
			default:
				System.out.println("default case");											
			}			
			if (c == 6) {
				break;
			}
			
			
		}		
		return lastRows;				
	}
	

}
