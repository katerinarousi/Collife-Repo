import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;

public class LoginFinalTest {
    private Connection mockConnection;
    private LoginFinal loginFinal;

    @Before
    public void setUp() {
        // create a mock for the Connection class
        mockConnection = mock(Connection.class);

        // create an instance of the LoginFinal class
        loginFinal = new LoginFinal();

        // set the connection to be used by the LoginFinal class
        loginFinal.conn = mockConnection;
    }

    @Test
    public void testLogin() {
        // set up the mock connection to return a certain value
        when(mockConnection.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?")).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        
        // call the login method and check the result
        boolean loginSuccessful = loginFinal.login("test_username", "test_password");
        assertEquals(true, loginSuccessful);
    }
}
