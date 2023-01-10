package collifePckg;

public class User {
	
	//q: ôá username, password êáé dept ôá ëáìâÜíåé ìÝóù áíôéêåéìÝíïõ áðü ôéò êëÜóåéò login/signin 
	//Þ ôá ïñßæù åîáñ÷Þò ùò îå÷ùñéóôÜ ðåäßá üðùò ðáñáêÜôù?
	
	private String username;
	private String password;
	private String uni;
	
	public User(String username, String password, String dept) {
		
		this.username = username;
		this.password = password;
	}
	
	public User() { 
		
	}
	
	//setters getters
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUni(String uni) {
		this.uni = uni;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUni() {
		return uni;
	}
	
	
	
	
	
}
