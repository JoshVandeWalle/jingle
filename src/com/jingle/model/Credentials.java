package com.jingle.model;

import javax.validation.constraints.Size;

/**
 * @author Henry Harvey 
 * The Credentials model contains login information for the User model
 */

public class Credentials {
	private int id;

	@Size(min = 2, max = 40, message = "Username must be between 2 and 40 characters long.")
	private String username;

	@Size(min = 2, max = 20, message = "Password must be between 2 and 20 characters long.")
	private String password;

	private int role;

	// Constructor with all fields
	public Credentials(int id, String username, String password, int role) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	// Constructor without id and role
	public Credentials(String username, String password) {
		this.id = -1;
		this.username = username;
		this.password = password;
		this.role = 0;
	}

	// Constructor without role
	public Credentials(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = 0;
	}

	// Default constructor
	public Credentials() {
		this.id = -1;
		this.username = "";
		this.password = "";
		this.role = -1;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Credentials [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}
