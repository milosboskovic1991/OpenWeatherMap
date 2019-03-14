package com.example.demo.security;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.entity.dto.UserLoginDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginService {

	@Autowired
	UserDao userDao;
	
	public static final String KEY = "1335A";

	public LoginService() {
		super();
	}
	
	public String authorize(UserLoginDto userLoginDto) {	
		User user = userDao.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword());
		if(user!=null) {
			String jws = Jwts.builder().setIssuer(user.getName())
					.setSubject(user.getEmail())
					.claim("name", user.getName()+""+user.getSurname())
					.setIssuedAt(Date.from(Instant.ofEpochSecond(1466796822L)))
					.signWith( SignatureAlgorithm.HS256,KEY).compact();
			return jws;
		}
		return "Unknown user!!!";	
	}
	
	public String getUserEmail(@RequestParam String token) {
		Jws<Claims> jws = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
		
		return jws.getBody().getSubject() ;
	}
	
	public boolean checkToken( String token) {
		String operatorEmail = this.getUserEmail(token);
		return operatorEmail != null;
	}
	
}
