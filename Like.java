import java.sql.ResultSet;
import java.sql.Statement;

public class Like {

	private String username;
	private String msg;

	public Like(String username, String msg) {
		this.username = username;
		this.msg = msg;

	}
	/* �� ��������� ��� � ������� ������� ��� ����� �� ����� ����(������ � �������������), � ���� ����� �� ���� ���������� ��� �� ���� �� �����
	 * ������� � ������� ����� ��� �� ���� ��� ��� ����. ���� ��������� �� ����, ���������� ��� ������ ��� ����� ��� ���� �� ���� ���� 1.
	 */

    public int countLike(String msg) {
		ResultSet resultset = null;

	    String selectSql = " SELECT like_id , msg_id from Collife.Like where msg_id = msg";
	    resultSet = statement.executeQuery(selectSql);

	    int count = 0;
	    while ( resultSet.next()) {
		      count++;
	    }
        return count;
	}
}