package com.example.demo.entity.dto;

public class UserDto {

	private String name;	
	private String surname;	
	private String email;	
	private String password;
	
	public UserDto() {
		super();
	}

	public UserDto(String name, String surname, String email, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	@Override
	public String toString() {
		return "UserDto [name=" + name + ", surname=" + surname + ", email=" + email + ", password=" + password + "]";
	}
	
}
