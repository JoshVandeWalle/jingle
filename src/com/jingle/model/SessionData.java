package com.jingle.model;

/**
 * @author Henry Harvey 
 * The SessionData model is for storing data in the session
 */

public class SessionData {

	private int users_id;

	private String firstName;

	private int credentials_id;

	private String username;

	private int role;

	public SessionData(int users_id, String firstName, int credentials_id, String username, int role) {
		this.users_id = users_id;
		this.firstName = firstName;
		this.credentials_id = credentials_id;
		this.username = username;
		this.role = role;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getCredentials_id() {
		return credentials_id;
	}

	public void setCredentials_id(int credentials_id) {
		this.credentials_id = credentials_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "SessionData [users_id=" + users_id + ", firstName=" + firstName + ", credentials_id=" + credentials_id + ", username=" + username + ", role=" + role + "]";
	}
	
}
