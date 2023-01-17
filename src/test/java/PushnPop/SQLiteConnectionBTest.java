package PushnPop;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

public class SQLiteConnectionBTest {

    @Test
    public void testConnectDb() {
    		Connection conn = SQLiteConnectionB.ConnectDb();
    		assertNotNull(conn); //successfully connected to SQLite DataBase
    }
}
