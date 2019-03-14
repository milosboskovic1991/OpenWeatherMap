package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.TemperatureForMailing;
import com.example.demo.entity.dto.UserCityBySubType;
import com.example.demo.entity.dto.UserDto;

public interface UserInterface {

	public User registerUser(UserDto userDto);
	public User updateUser(User user);
	public String deleteUser(String id);	
	
	public Subscription addSubscription(Subscription subscription, String email);
	public Subscription updateSubscription(Subscription subscription, String email);
	public String deleteSubscription(Subscription subscription, String email);
	public List<Subscription> findAllSubscription(String email);
	
	public List<TemperatureForMailing> getListOfCities(List<String> cities);
	public List<UserCityBySubType> userCityBySybType(Long subscriptionType);
	
	
}
