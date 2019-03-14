package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.City;
import com.example.demo.entity.dto.CityDto;

public interface CityInterface {

	public List<CityDto> findAll();
	public City getCityByName(String name);
	public List<City> getTemperatureForAllCities(List<City> cities);
	public void updateCityTemperature();
	
}
