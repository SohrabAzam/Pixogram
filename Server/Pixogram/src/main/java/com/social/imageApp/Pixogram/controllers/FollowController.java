package com.social.imageApp.Pixogram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.Followers;
import com.social.imageApp.Pixogram.model.User;
import com.social.imageApp.Pixogram.services.AccountService;
import com.social.imageApp.Pixogram.services.FollowService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/follow")
public class FollowController {

	@Autowired
	FollowService followService;
	
	@Autowired
	AccountService accountService;
	
	@PostMapping(path="/all")
	public List<Followers> fetchAll(@RequestBody User user) {
		return followService.fetchAll(user);
	}
	
	@PostMapping(path="/follow")
	public Followers follow(@RequestBody Followers follower) {
		System.out.println(follower);
		User user = accountService.loadUserById(follower.getUserId());
		Followers follower1 = followService.getFollower(follower.getFollowerId(), user.getUserId());
		System.out.println(follower1);
		if (follower1 == null)
			follower = followService.createFollower(follower);
		else {
			follower1.setFollowing('Y');
			follower = followService.follow(follower1);
		}
		return follower;
	}
	
	@PostMapping(path="/unfollow")
	public Followers unfollow(@RequestBody Followers follower) {
		System.out.println(follower);
		follower = followService.unfollow(follower);
		return follower;
	}
}
