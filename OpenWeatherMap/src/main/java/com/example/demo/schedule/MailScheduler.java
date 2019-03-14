package com.example.demo.schedule;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.entity.dto.TemperatureForMailing;
import com.example.demo.entity.dto.UserCityBySubType;
import com.example.demo.mail.MailService;
import com.example.demo.service.implementation.CityService;
import com.example.demo.service.implementation.UserService;


@Component
public class MailScheduler {

	CityService cityService;
	UserService userService;
	MailService mailService;
	
	@Autowired
	public MailScheduler(CityService cityService, UserService userService, MailService mailService) {
		super();
		this.cityService = cityService;
		this.userService = userService;
		this.mailService = mailService;
	}
	
	@SuppressWarnings("deprecation")
	@Scheduled(cron="0 0 * ? * * ")
	public void sendEmail() {
		Long time = (long) 1;
		List<UserCityBySubType> userCityBySybType= userService.userCityBySybType(time);
		for(UserCityBySubType pom:userCityBySybType) {
			String recipient = pom.getEmail();
			List<String> cities = pom.getCities();
			List<TemperatureForMailing> body = userService.getListOfCities(cities);
			mailService.sendEmail(recipient, body.toString());
		}
		Calendar cal = Calendar.getInstance();
		if(cal.getTime().getHours()%12==0) {
			time = (long) 12;
			List<UserCityBySubType> userCityBySybType12= userService.userCityBySybType(time);
			for(UserCityBySubType pom:userCityBySybType12) {
				String recipient = pom.getEmail();
				List<String> cities = pom.getCities();
				List<TemperatureForMailing> body = userService.getListOfCities(cities);
				mailService.sendEmail(recipient, body.toString());
			}
		}
		if(cal.getTime().getHours()%24==0) {
			time = (long) 24;
			List<UserCityBySubType> userCityBySybType24= userService.userCityBySybType(time);
			for(UserCityBySubType pom:userCityBySybType24) {
				String recipient = pom.getEmail();
				List<String> cities = pom.getCities();
				List<TemperatureForMailing> body = userService.getListOfCities(cities);
				mailService.sendEmail(recipient, body.toString());
			}
		}
	}
	
	
}
