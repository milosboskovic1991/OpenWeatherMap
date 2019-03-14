package com.example.demo.entity;

import java.util.Date;

public class SavedTemperatures {

	private Date measured;
	private Double temperature;
	
	public SavedTemperatures() {
		super();
	}

	public SavedTemperatures(Date measured, Double temperature) {
		super();
		this.measured = measured;
		this.temperature = temperature;
	}

	public Date getMeasured() {
		return measured;
	}

	public void setMeasured(Date measured) {
		this.measured = measured;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "SavedTemperatures [measured=" + measured + ", temperature=" + temperature + "]";
	}
	
}
