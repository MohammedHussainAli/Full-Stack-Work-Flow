package com.workflow.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.workflow.springboot.model.User;
import com.workflow.springboot.repository.UserRepository;

@Service
public class RegistrationService {

	@Autowired
	private UserRepository userRepo;
	
	//Save User
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	//To check the email is already registered or not before saving into the db
	public User fetchUserByEmailId(String email) {
		return userRepo.findByEmailId(email);
	}
	
	//
	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return userRepo.findByEmailIdAndPassword(email, password);
	}
}
