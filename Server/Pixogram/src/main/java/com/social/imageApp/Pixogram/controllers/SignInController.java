package com.social.imageApp.Pixogram.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.User;
import com.social.imageApp.Pixogram.services.AccountService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/account")
public class SignInController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(path="/login")
	public User registerUser(@RequestBody User user) {
		User user1 = accountService.checkUser(user);
		System.out.println(user);
		System.out.println(user1);

		if (user1 != null)
			return user1;
		else
			return null;
	}
}
