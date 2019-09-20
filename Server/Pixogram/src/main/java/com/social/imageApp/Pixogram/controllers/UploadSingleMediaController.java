package com.social.imageApp.Pixogram.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.Media;
import com.social.imageApp.Pixogram.services.UploadService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/media")
public class UploadSingleMediaController {

	@Autowired
	UploadService uploadService;
	
	@PostMapping(path="/uploadSingle")
	public Media saveSingleMedia(@RequestBody Media media) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		media.setUploadDate(formatter.format(date));
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		media.setUploadTime(format.format(date));
		System.out.println(media);
		media = uploadService.saveSingleMedia(media);
		return media;
	}
}
