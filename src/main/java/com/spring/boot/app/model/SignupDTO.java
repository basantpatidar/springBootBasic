package com.spring.boot.app.model;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties(value= {"lastName","username"})
@JsonFilter(value="signupFilter")
public class SignupDTO {
	
	//@JsonIgnore
	private long id;
	private String firstName;
	//@JsonIgnore
	private String lastName;
	private String emailAddress;
	private String username;
	private String password;
	
	public SignupDTO() {
		
	}
	
	public SignupDTO(long id, String firstName, String lastName, String emailAddress, String username, String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.username = username;
		this.password = password;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
	
}
