package com.example.demo.entity.dto;

import java.util.List;

public class UserCityBySubType {

	private String name;
	private String surname;
	private String email;
	private List<String> cities;
	
	public UserCityBySubType() {
		super();
	}

	public UserCityBySubType(String name, String surname, String email, List<String> cities) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.cities = cities;
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

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "UserCityBySubType [name=" + name + ", surname=" + surname + ", email=" + email + ", cities=" + cities
				+ "]";
	}
	
}
