package com.ms.mongowheels.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ms.mongowheels.beans.User;
import com.ms.mongowheels.repositories.UserRepository;



@Controller
public class SecurityController {

	@Autowired 
	@Lazy
	private UserRepository userRepo;
	
	@GetMapping("/login")
	public String goLogin() {
		return "login";
	}
	
	@GetMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
	
	@GetMapping("/registerUser")
	public String getToRegistration() {
		return "registration";
	}
	
	@PostMapping("/registerUser")
	public String collectRegistrationData(@RequestParam String username,
											@RequestParam String password) {
		userRepo.addUser(username, password);
		User user = userRepo.findUserAccount(username);
		userRepo.addRole(user.getUserId(), 1);
		return "home";
	}
}
