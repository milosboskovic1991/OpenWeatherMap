package com.example.demo.entity.dto;

public class TemperatureForMailing {

	private String city;
	private Double temperature;
	private Double minTemperature;
	private Double maxTemperature;
	
	public TemperatureForMailing() {
		super();
	}

	public TemperatureForMailing(String city, Double temperature, Double minTemperature, Double maxTemperature) {
		super();
		this.city = city;
		this.temperature = temperature;
		this.minTemperature = minTemperature;
		this.maxTemperature = maxTemperature;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Double getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(Double minTemperature) {
		this.minTemperature = minTemperature;
	}

	public Double getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(Double maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	@Override
	public String toString() {
		return "TemperatureForMailing [city=" + city + ", temperature=" + temperature + ", minTemperature="
				+ minTemperature + ", maxTemperature=" + maxTemperature + "]";
	}
	
}
