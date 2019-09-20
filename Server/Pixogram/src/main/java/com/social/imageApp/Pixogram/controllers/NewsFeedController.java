package com.social.imageApp.Pixogram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.Activity;
import com.social.imageApp.Pixogram.model.User;
import com.social.imageApp.Pixogram.services.AccountService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/account")
public class NewsFeedController {

	@Autowired
	AccountService accountService;
	
	@PostMapping(path="/newsfeed")
	public List<Activity> getActivities(@RequestBody User user){
		return accountService.getActivities(user);
	}
}
