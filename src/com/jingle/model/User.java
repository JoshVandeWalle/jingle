package com.jingle.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * @author Henry Harvey 
 * The User model is the user object model of the application
 */

public class User {
	private int id;

	@Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters long.")
	private String firstName;

	@Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters long.")
	private String lastName;

	@Size(min = 10, max = 40, message = "Email must be between 10 and 40 characters long.")
	private String email;

	@Size(min = 10, max = 10, message = "Phone number must be 10 characters long.")
	@Digits(integer = 10, fraction = 0, message = "Phone number must be digits.")
	private String phone;

	private Credentials credentials;
	private int credentials_id;

	// Constructor with all fields
	public User(int id, String firstName, String lastName, String email, String phone, Credentials credentials) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.credentials = credentials;
		this.credentials_id = credentials.getId();
	}

	// Constructor without id
	public User(String firstName, String lastName, String email, String phone, Credentials credentials) {
		this.id = -1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.credentials = credentials;
		this.credentials_id = credentials.getId();
	}

	// Default constructor
	public User() {
		this.id = -1;
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phone = "";
		this.credentials = null;
		this.credentials_id = -1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public int getCredentials_id() {
		return credentials_id;
	}

	public void setCredentials_id(int credentials_id) {
		this.credentials_id = credentials_id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", credentials=" + credentials + "]";
	}

}
