package com.example.demo.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.service.implementation.CityService;

@Component
public class TemperatureUpdateScheduler {

	@Autowired
	CityService cityService;
	
	@Scheduled(cron="0 0 0/1 1/1 * ?")//(cron="0 * * ? * *")
	public void updateAllTemperatures() {
		cityService.updateCityTemperature();
	}
}
