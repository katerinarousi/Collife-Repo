package collifePckg;

public class User {
	
	//q: �� username, password ��� dept �� �������� ���� ������������ ��� ��� ������� login/signin 
	//� �� ����� ������� �� ��������� ����� ���� ��������?
	
	private String username;
	private String password;
	private String dept;
	
	public User(String username, String password, String dept) {
		
		this.username = username;
		this.password = password;
		this.dept = dept;
	}
	
	public User() { //������������� ����� �������� �� �������� ��� ���������
		
	}
	
	//setters getters
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getDept() {
		return dept;
	}
	
	
	
	
}
 