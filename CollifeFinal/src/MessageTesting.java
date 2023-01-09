import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JTextPane;

public class MessageTesting {
	
	static Connection conn = null;
	static PreparedStatement state = null;
	//JTextPane showMess = new JTextPane();
	static ResultSet rs;
	ArrayList<String> a = new ArrayList<>();

    public String getMessage(ArrayList<String> i) {
		return i.get(i.size());
	}

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
		System.out.println(myID);
		 return myID;
	 }
	

    public void insertMessage(String id,String name,String des,String category) throws SQLException {
		
    	//System.out.println(id + name + des + category);
    	String insertSql = "INSERT INTO Message (msg_id,username,description,category) "
				+ "VALUES (?,?,?,?);";
		conn = SQLiteConnectionB.ConnectDb();
		PreparedStatement state = conn.prepareStatement(insertSql);
		System.out.println("into msg");
		state.setString(1, id);
		state.setString(2, name);
		state.setString(3, des);
		state.setString(4, category);
		
	   
		//ResultSet resultSet = null;
	    try {

		  state.execute();

        } catch (Exception e) {
		  e.printStackTrace();
	    }
	    state.close();
	}
    
    
	public void selectmessage(String category) {

		
		
		String myselect = " SELECT * FROM Message WHERE category = ?;";
		try {
			conn = SQLiteConnectionB.ConnectDb();
			state= conn.prepareStatement(myselect);
			state.setString(1, category);

			rs = state.executeQuery();
        
			while(rs.next()) {
    	
				String msg = rs.getString("description");
				//System.out.println(msg);
				a.add(msg);
			}
			
			
			ChatFrameFinal.showMess.setText(a.toString().replaceAll("[\\[\\]//,]", ""));
			
			state.close();
			rs.close();
		} catch (Exception e1) {

    	}

	}
	
public static String getMax(ArrayList<String> a, String top) {
		
		int[] intFirsts = new int[a.size()];
		String[] temp3 = new String[a.size()];

		int[] intSeconds = new int[a.size()];
		
		for (int i = 0; i < a.size(); i++) {
			
			intFirsts[i] = Integer.parseInt(a.get(i).substring(0,1));
			temp3[i] = a.get(i).substring(2);
			intSeconds[i] = Integer.parseInt(temp3[i]);
			
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
		
		return String.valueOf(intSeconds[maxp]);
				
	}

	//public static int getTop(ArrayList)
	
	
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
					System.out.println("last row for general is " + lastRows[0]);
					check1 = true;
					c++;
				}
				break;
			case "2":
				cases = "2";

				if (check2 == false) {
					
					lastRows[1] = Integer.parseInt(getMax(a, cases));					
					System.out.println("last row for volunteer is " + lastRows[1]);
					check2 = true;
					c++;
				}
				break;
				
			case "3":
				cases = "3";

				if (check3 == false) {
					
					lastRows[2] = Integer.parseInt(getMax(a, cases));					
					System.out.println("last row for nightlife is " + lastRows[2]);
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
