package com.example.demo.entity.dto;

import java.util.Date;

import org.bson.types.ObjectId;

import com.example.demo.entity.City;

public class CityDto {

	private ObjectId id;
	private String name;
	private Date lastWeatherInformation;
	private Double currentTemperature;
	
	public CityDto() {
		super();
	}

	public CityDto(ObjectId id, String name, Date lastWeatherInformation, Double currentTemperature) {
		super();
		this.id = id;
		this.name = name;
		this.lastWeatherInformation = lastWeatherInformation;
		this.currentTemperature = currentTemperature;
	}
	
	public CityDto(City city) {
		this.id = city.getId();
		this.name = city.getName();
		this.lastWeatherInformation = city.getLastWeatherInformation();
		this.currentTemperature = city.getMain().getTemp()-273.15;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastWeatherInformation() {
		return lastWeatherInformation;
	}

	public void setLastWeatherInformation(Date lastWeatherInformation) {
		this.lastWeatherInformation = lastWeatherInformation;
	}

	public Double getCurrentTemperature() {
		return currentTemperature;
	}

	public void setCurrentTemperature(Double currentTemperature) {
		this.currentTemperature = currentTemperature;
	}

	@Override
	public String toString() {
		return "CityDto [id=" + id + ", name=" + name + ", lastWeatherInformation=" + lastWeatherInformation
				+ ", currentTemperature=" + currentTemperature + "]";
	}
	
}
