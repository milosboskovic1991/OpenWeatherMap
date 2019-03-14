package com.example.demo.entity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="city")
public class City {

	private Coordinates coord;
	private Weather[] weather;
	private String base;
	private Main main;
	private Long visibility;
	private Wind wind;
	private Clouds clouds;
	private Long dt;
	private Sys sys;
	@Id
	private String id;
	private String name;
	private Date lastWeatherInformation;
	private List<SavedTemperatures> savedTemperatures;
	
	public City() {
		super();
	}

	public City(Coordinates coord, Weather[] weather, String base, Main main, Long visibility, Wind wind, Clouds clouds,
			Long dt, Sys sys, String id, String name, Date lastWeatherInformation,
			List<SavedTemperatures> savedTemperatures) {
		super();
		this.coord = coord;
		this.weather = weather;
		this.base = base;
		this.main = main;
		this.visibility = visibility;
		this.wind = wind;
		this.clouds = clouds;
		this.dt = dt;
		this.sys = sys;
		this.id = id;
		this.name = name;
		this.lastWeatherInformation = new Date();
		this.savedTemperatures = savedTemperatures;
	}

	public Coordinates getCoord() {
		return coord;
	}

	public void setCoord(Coordinates coord) {
		this.coord = coord;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public Long getVisibility() {
		return visibility;
	}

	public void setVisibility(Long visibility) {
		this.visibility = visibility;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Long getDt() {
		return dt;
	}

	public void setDt(Long dt) {
		this.dt = dt;
	}

	public Sys getSys() {
		return sys;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public List<SavedTemperatures> getSavedTemperatures() {
		return savedTemperatures;
	}

	public void setSavedTemperatures(List<SavedTemperatures> savedTemperatures) {
		this.savedTemperatures = savedTemperatures;
	}

	@Override
	public String toString() {
		return "City [coord=" + coord + ", weather=" + Arrays.toString(weather) + ", base=" + base + ", main=" + main
				+ ", visibility=" + visibility + ", wind=" + wind + ", clouds=" + clouds + ", dt=" + dt + ", sys=" + sys
				+ ", id=" + id + ", name=" + name + ", lastWeatherInformation=" + lastWeatherInformation
				+ ", savedTemperatures=" + savedTemperatures + "]";
	}
	
}
