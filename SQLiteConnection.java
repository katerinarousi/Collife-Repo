import java.sql.*;

public class SQLiteConnection {

	 String url = "C:\\Users\\paras\\eclipse-workspace\\SQLiteConnection\\cc_db.db\\";	
     Connection conn = null;
     public static Connection ConnectDb() {
     
     try {
    	 
    	 Class.forName("org.sqlite.JDBC");
    	 Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\paras\\eclipse-workspace\\SQLiteConnection\\cc_db.db\\");
    	 System.out.println("SQLite DB connected");
    	 return conn;
    	 
     }catch(Exception e) {
    	 System.out.println(e);
    	 return null;
     }
     }
     }
	


