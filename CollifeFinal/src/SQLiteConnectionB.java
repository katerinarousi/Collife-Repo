
	
import java.sql.*;

public class SQLiteConnectionB {

		 
     Connection conn = null;
     public static Connection ConnectDb() {
     
     //Declare JDBC Connection
	    	     
     try {
    	 Class.forName("org.sqlite.JDBC");
    	 Connection conn=DriverManager.getConnection("jdbc:sqlite:cc_db.db");
    	 System.out.println("SQLite DB connected");
    	 return conn;
    	 
     }catch(Exception e) {
    	 System.out.println(e);
    	 return null;
     }
     }
     }


