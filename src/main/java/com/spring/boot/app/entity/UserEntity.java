package com.spring.boot.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserEntity {
	
	@GeneratedValue
	@Id
	private long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column(nullable=false)
	private String emailAddress;
	
	@Column(nullable=false)
	private String username;
	
	@Column
	private String password;
	
	public UserEntity() {
		
	}
	
	public UserEntity(long id, String firstName, String lastName, String emailAddress, String username,
			String password) {
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
