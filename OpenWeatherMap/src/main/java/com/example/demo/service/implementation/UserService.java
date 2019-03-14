package com.example.demo.service.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CityDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.City;
import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.TemperatureForMailing;
import com.example.demo.entity.dto.UserCityBySubType;
import com.example.demo.entity.dto.UserDto;
import com.example.demo.service.UserInterface;

@Service
public class UserService implements UserInterface{
	
	UserDao userDao;
	CityDao cityDao;
	
	@Autowired
	public UserService(UserDao userDao, CityDao cityDao) {
		super();
		this.userDao = userDao;
		this.cityDao = cityDao;
	}

	@Override
	public User registerUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		user.setSurname(userDto.getSurname());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return userDao.save(user);	
	}

	@Override
	public User updateUser(User user) {
		return userDao.save(user);
	}

	@Override
	public String deleteUser(String id) {
		userDao.deleteById(id);;
		return "Object deleted!!!";
	}

	@Override
	public Subscription addSubscription(Subscription subscription, String email) {
		Optional<User> optionalUser = userDao.findByEmail(email);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			try {
				List<Subscription> usersSubscriptions = user.getSubscriptions();
				usersSubscriptions.add(subscription);
				user.setSubscriptions(usersSubscriptions);
				userDao.save(user);
				return subscription;
			}catch(NullPointerException e) {
				List<Subscription> usersSubscriptions = new ArrayList<Subscription>();
				usersSubscriptions.add(subscription);
				user.setSubscriptions(usersSubscriptions);
				userDao.save(user);
				return subscription;
			}
		}else {
			return null;
		}
		
	}

	@Override
	public Subscription updateSubscription(Subscription subscription, String email) {
		Optional<User> optionalUser = userDao.findByEmail(email);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			try {
				List<Subscription> usersSubscriptions = user.getSubscriptions();
				String city = subscription.getCity();
				for(Subscription sub:usersSubscriptions) {
					if(sub.getCity().equalsIgnoreCase(city)) {
						sub.setSubscriptionType(subscription.getSubscriptionType());
					}	
				}
				user.setSubscriptions(usersSubscriptions);
				userDao.save(user);
				return subscription;
			}catch(NullPointerException e) {
				List<Subscription> usersSubscriptions = new ArrayList<Subscription>();
				usersSubscriptions.add(subscription);
				user.setSubscriptions(usersSubscriptions);
				userDao.save(user);
				return subscription;
			}
		}else {
			return null;
		}	
	}

	@Override
	public String deleteSubscription(Subscription subscription, String email) {
		Optional<User> optionalUser = userDao.findByEmail(email);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			try {
				List<Subscription> usersSubscriptions = user.getSubscriptions();
				List<Subscription> newUsersSubscriptions = new ArrayList<>();
				for(Subscription sub:usersSubscriptions) {
					if(!sub.getCity().equalsIgnoreCase(subscription.getCity())) {
						newUsersSubscriptions.add(sub);
					}
				}
				user.setSubscriptions(newUsersSubscriptions);
				userDao.save(user);
			}catch(NullPointerException e) {
				return "There is no user with this email!!";
			}			
		}
		return "Subscription deleted!!!";	
	}

	@Override
	public List<Subscription> findAllSubscription(String email) {
		Optional<User> optionalUser = userDao.findByEmail(email);
		if(optionalUser.isPresent()) {
			User user = optionalUser.get();
			List<Subscription> usersSubscriptions = user.getSubscriptions();
			return usersSubscriptions;
		}else {
			throw new NullPointerException("There is no user with this email!!!");
		}
	}

	@Override
	public List<TemperatureForMailing> getListOfCities(List<String> cities) {
		List<TemperatureForMailing> tempsForMailing = new ArrayList<>();
		for(String c:cities) {
			TemperatureForMailing tempForMailing = new TemperatureForMailing();
			try {
				City city = cityDao.findByName(c);
				tempForMailing.setCity(c);
				tempForMailing.setTemperature(city.getMain().getTemp()-273.15);
				tempForMailing.setMinTemperature(city.getMain().getTemp_min()-273.15);
				tempForMailing.setMaxTemperature(city.getMain().getTemp_max()-273.15);
				tempsForMailing.add(tempForMailing);
			}catch(NullPointerException e) {
				System.out.println("There is no city with that name!!!");
			}
		}
		return tempsForMailing;
	}

	@Override
	public List<UserCityBySubType> userCityBySybType(Long subscriptionType) {
		List<UserCityBySubType> userCityBySybType = new ArrayList<>();
		List<User> users = userDao.findAll();
		for(User u:users) {
			UserCityBySubType userCityBySubscriptionType = new UserCityBySubType();
			userCityBySubscriptionType.setName(u.getName());
			userCityBySubscriptionType.setSurname(u.getSurname());
			userCityBySubscriptionType.setEmail(u.getEmail());
			List<String> cities = new ArrayList<>();
			try {
				List<Subscription> usersSubscriptions = u.getSubscriptions();
				if(usersSubscriptions!=null) {
					for(Subscription s:usersSubscriptions) {
						if(s.getSubscriptionType()==subscriptionType) {
							cities.add(s.getCity());
						}
					}
				}
			}catch(NullPointerException e) {
				System.out.println("There is no subscriptions!!!");
			}
			userCityBySubscriptionType.setCities(cities);
			userCityBySybType.add(userCityBySubscriptionType);
		}
		return userCityBySybType;
	}

}
