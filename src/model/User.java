package model;

public class User implements Comparable<User>{

	private String username;
	private String password;
	private String email;
	
	public User(String userN, String ema, String pass) {
		username = userN;
		email = ema;
		password = pass;
	}

	//Gettters and setters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int compareTo(User user) {
		return username.compareTo(user.getUsername());
	}	
}
