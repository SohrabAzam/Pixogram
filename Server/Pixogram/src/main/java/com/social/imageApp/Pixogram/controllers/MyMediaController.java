package com.social.imageApp.Pixogram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.Media;
import com.social.imageApp.Pixogram.model.User;
import com.social.imageApp.Pixogram.services.MyMediaService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/mymedia")
public class MyMediaController {
	
	@Autowired
	MyMediaService myMediaService;
	
	@PostMapping(path="/getAll")
	public List<Media> getAllMedia(@RequestBody User user){
		List<Media> mediaList = myMediaService.getAllMedia(user);
		System.out.println(mediaList);
		return mediaList;
	}
}
