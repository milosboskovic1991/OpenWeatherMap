package com.example.demo.service.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.CityDao;
import com.example.demo.entity.City;
import com.example.demo.entity.SavedTemperatures;
import com.example.demo.entity.dto.CityDto;
import com.example.demo.properties.OpenWeatherMapProperties;
import com.example.demo.service.CityInterface;

@Service
public class CityService implements CityInterface {

	@Autowired
	CityDao cityDao;
	
	@Override
	public List<CityDto> findAll() {
		List<City> cities= cityDao.findAll();
		List<CityDto> cityDto = new ArrayList<>();
		for(City city:cities) {
			CityDto dtoCity = new CityDto();
			dtoCity.setId(city.getId());
			dtoCity.setName(city.getName());
			dtoCity.setLastWeatherInformation(city.getLastWeatherInformation());
			dtoCity.setCurrentTemperature(city.getMain().getTemp());
			cityDto.add(dtoCity);
		}
		return cityDto;
	}

	@Override
	public City getCityByName(String name) {
		return cityDao.findByName(name);
	}

	@Override
	public void updateCityTemperature() {
		List<City> cities = cityDao.findAll();
		List<City> updatedCities = getTemperatureForAllCities(cities);
		for(City city:updatedCities) {
			city.setLastWeatherInformation(new Date());
			SavedTemperatures savedTemperatures = new SavedTemperatures();
			savedTemperatures.setTemperature(city.getMain().getTemp());
			savedTemperatures.setMeasured(new Date());	
			
			try {
				City existingCity = cityDao.findByName(city.getName());
				List<SavedTemperatures> storedTemperatures = existingCity.getSavedTemperatures();
				storedTemperatures.add(savedTemperatures);
				city.setSavedTemperatures(storedTemperatures);
				cityDao.save(city);
			}catch(NullPointerException e) {
				List<SavedTemperatures> storageIsEmpty = new ArrayList<>(); 
				storageIsEmpty.add(savedTemperatures);
				city.setSavedTemperatures(storageIsEmpty);
				cityDao.save(city);
			}
		}
		
	}

	@Override
	public List<City> getTemperatureForAllCities(List<City> cities) {
		
		List<City> updatedCities = new ArrayList<>();		
		RestTemplate template = new RestTemplate();	
		HttpHeaders headers = new HttpHeaders();
		
		for(City city : cities) {
			headers.set(OpenWeatherMapProperties.keyName,OpenWeatherMapProperties.keyValue);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			String ApiCall = OpenWeatherMapProperties.url+city.getName();
			HttpEntity<String> entity = new HttpEntity<String>(headers);
			ResponseEntity<City> response = template.exchange(ApiCall, HttpMethod.GET, entity, City.class);
			City c = response.getBody(); 
			updatedCities.add(c);
		}
		
		return updatedCities;
	}

}
