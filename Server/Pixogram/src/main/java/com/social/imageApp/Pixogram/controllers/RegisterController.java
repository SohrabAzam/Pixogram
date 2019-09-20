package com.social.imageApp.Pixogram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.User;
import com.social.imageApp.Pixogram.services.AccountService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value="/account")
public class RegisterController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping(path="/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		System.out.println("controller" + user);
		user = accountService.registerUser(user);
		System.out.println(user);
		return new ResponseEntity<User>(user,null, HttpStatus.CREATED);
	}
	
	@PostMapping(path="/check")
	public User checkUserName(@RequestBody String username) {
		User user = accountService.checkUserName(username);
		return user;
	}
	
}
