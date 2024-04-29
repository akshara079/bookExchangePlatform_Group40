package com.bits.bookapplication.to;

public class UserUpdateTO {
	
	private int id;

	private String username;
	
	private String username_updated;


	private String password;

	private String name;

	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername_updated() {
		return username_updated;
	}

	public void setUsername_updated(String username_updated) {
		this.username_updated = username_updated;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
