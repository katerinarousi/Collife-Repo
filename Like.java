package collifePckg;

public class Like extends Action {
	
	//������ ����� �� �� ������� �� �� ����. 
	//����� �� ����� ������ ��� ���� ���� ��� ��� ������? 
	//����� ������ ��� ���������� ����� ������� ��� ����� �� ����������� � ��� �������?
	
	
	private String username;
	private String post;
	private String position;
	private int countLikes; 
	
	public Like(String username, String post, String position) {
		super(username);
		this.post = post;
		this.position = position;
	
	}
	/* �� ��������� ��� � ������� ������� ��� ����� �� ����� ����(������ � �������������), � ���� ����� �� ���� ���������� ��� �� ���� �� �����
	 * ������� � ������� ����� ��� �� ���� ��� ��� ����. ���� ��������� �� ����, ���������� ��� ������ ��� ����� ��� ���� �� ���� ���� 1.
	 */
	public String getUsername() {
		super.getUsername();
	}
	
	public String getPosition() {
		return position;
	}
	
	public int countLikes() {
		
		countLikes++;
		return countLikes;
		
	}
}
