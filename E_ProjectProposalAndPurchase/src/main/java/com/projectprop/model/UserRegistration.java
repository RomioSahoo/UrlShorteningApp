package com.projectprop.model;

public class UserRegistration {

	private String firstName;
	private String lastName;
	private String contact;
	private String email;
	private String password;
	private String skills;

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User Registration details  ").append("firstname = ").append(firstName);
		builder.append(", lastname = ").append(lastName);
		builder.append(", contact number= ").append(contact);
		builder.append(", email= ").append(email);
		builder.append(", password= ").append(password);
		builder.append(", skills= ").append(skills);

		return builder.toString();
	}

}
