package com.example.demo.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CityDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.City;
import com.example.demo.entity.Subscription;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.CityDto;
import com.example.demo.entity.dto.UserDto;
import com.example.demo.entity.dto.UserLoginDto;
import com.example.demo.security.LoginService;
import com.example.demo.service.implementation.CityService;
import com.example.demo.service.implementation.UserService;

@RestController
@RequestMapping("/")
public class OpenWeatherMapController {

	UserService userService;
	CityService cityService;
	LoginService loginService;
	UserDao userDao;
	CityDao cityDao;
	
	@Autowired
	public OpenWeatherMapController(UserService userService, CityService cityService, LoginService loginService,
			UserDao userDao, CityDao cityDao) {
		super();
		this.userService = userService;
		this.cityService = cityService;
		this.loginService = loginService;
		this.userDao = userDao;
		this.cityDao = cityDao;
	}
	
	@PostMapping("user/register")
	public User register(@RequestBody UserDto userDto) {
		return userService.registerUser(userDto);
	}
	
	@PostMapping("user/login")
	public String getJwt(@RequestBody UserLoginDto userLoginDto) {
		return loginService.authorize(userLoginDto);
	}
	
	@PutMapping("user/update")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping("user/delete/{id}")
	public void deleteUser(@PathVariable(name="id") String id) {
		userService.deleteUser(id);
	}
	
	@RequestMapping("city/forecast/{name}") //ne radi
	public City getForecast(@PathVariable(name="name") String name) {
		return cityService.getCityByName(name);
	}
	
	@RequestMapping("city/findAll") //ne radi
	public List<CityDto> findAll(){
		return cityService.findAll();
	}
	
	@PostMapping("addSubscription")
	public Subscription subscribe(@RequestBody Subscription subscription, HttpServletRequest httpServletRequest) { //null pointeri kod maila
		String email = (String) httpServletRequest.getSession().getAttribute("email"); // probao i sa sesijom i nece
		return userService.addSubscription(subscription, email);
	}
	
	@RequestMapping("findAllSubscription")
	public List<Subscription> listUserSubscriptions(HttpServletRequest httpServletRequest){ //null pointeri kod maila
		String email = (String) httpServletRequest.getAttribute("email");
		return userService.findAllSubscription(email);
	}
	
	@PutMapping("updateSubscription")
	public Subscription updateSubscription(@RequestBody Subscription subscription, HttpServletRequest httpServletRequest) { //null pointeri kod maila
		String email = (String) httpServletRequest.getAttribute("email");
		return userService.updateSubscription(subscription, email);
	}
	
	@DeleteMapping("subscription/delete")
	public void deleteSub(@RequestBody Subscription subscription,HttpServletRequest httpServletRequest) { //null pointeri kod maila
		String email = (String) httpServletRequest.getAttribute("email");
		userService.deleteSubscription(subscription, email);
	}
	
}
