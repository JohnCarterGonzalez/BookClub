package com.johncarter.BookClub.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterLogin {

	@NotEmpty(message="Email is required")
	@Email(message="Please enter a valid email")
	private String email;

	@NotEmpty(message="Password is required")
	@Size(min=3, max=255, message = "Please enter a valid password")
	private String password;

	public RegisterLogin() {
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
    
}
