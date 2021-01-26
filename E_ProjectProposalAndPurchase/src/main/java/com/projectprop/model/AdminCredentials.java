package com.projectprop.model;

public class AdminCredentials {

	private String email;
	private String password;

	// Generating Getters and Setters...
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
		builder.append("Admin Credentials  ").append("email = ").append(email);
		builder.append(", password= ").append(password);

		return builder.toString();
	}

}
