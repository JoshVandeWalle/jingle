package com.jingle.model;

import javax.validation.constraints.Pattern;
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
	// @Pattern(regexp = "[\\d]{6}", message = "phone number must only include
	// numbers")
	private String phone;

	private Credentials credentials;

	// Constructor with all fields
	public User(int id, String firstName, String lastName, String email, String phone, Credentials credentials) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.credentials = credentials;
	}

	// Constructor with all fields except id's
	public User(String firstName, String lastName, String email, String phone, Credentials credentials) {
		this.id = -1;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.credentials = credentials;
	}

	// Default constructor
	public User() {
		super();
		this.id = -1;
		this.firstName = "first name";
		this.lastName = "last name";
		this.email = "email";
		this.phone = "1234567890";
		this.credentials = null;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", credentials=" + credentials + "]";
	}

}
