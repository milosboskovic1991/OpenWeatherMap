package com.example.demo.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public interface UserDao extends MongoRepository<User, String>{

	public User findByEmailAndPassword(String email, String password);
	public Optional<User> findByEmail(String email);
}
