package com.social.imageApp.Pixogram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.User;
import com.social.imageApp.Pixogram.services.AccountService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/account")
public class SearchController {
	@Autowired
	AccountService accountService;
	
	@GetMapping(path="/fetchUsers")
	public List<User> fetchUsers(){
		List<User> users =  accountService.fetchUsers();
		System.out.println(users);
		return users;
	}
	
	@PostMapping(path="/getUser")
	public User loadUserById(@RequestBody User user) {
		//System.out.println(user);
		user = accountService.loadUserById(user.getUserId());
		//System.out.println(user);
		return user;
	}
}
