package com.social.imageApp.Pixogram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.Blocked;
import com.social.imageApp.Pixogram.model.User;
import com.social.imageApp.Pixogram.services.BlockedService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/blocked")
public class BlockedController {
	
	@Autowired
	BlockedService blockedService;
	
	@PostMapping(path="/all")
	public List<Blocked> getAllBlocked(@RequestBody User user){
		return blockedService.getAllBlocked(user);
	}
	
	@PostMapping(path="/block")
	public Blocked block(@RequestBody Blocked blocked) {
		return blockedService.block(blocked);
	}

	@PostMapping(path="/unblock")
	public Blocked unblock(@RequestBody Blocked blocked) {
		System.out.println(blocked);
		return blockedService.unblock(blocked);
	}
	
}
