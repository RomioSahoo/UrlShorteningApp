package com.projectprop.model;

public class AdminRegistration {
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String email;
	private String password;

	// generating parameterised constructor
	public AdminRegistration(String firstName, String lastName, String contactNumber, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.email = email;
		this.password = password;
	}

	public AdminRegistration() {

	}

	// Generating Getters and Setters...
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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User Registration details  ").append("firstname = ").append(firstName);
		builder.append(", lastname = ").append(lastName);
		builder.append(", contact number= ").append(contactNumber);
		builder.append(", email= ").append(email);
		builder.append(", password= ").append(password);

		return builder.toString();
	}

}
