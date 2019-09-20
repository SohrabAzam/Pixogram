package com.social.imageApp.Pixogram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social.imageApp.Pixogram.model.Comment;
import com.social.imageApp.Pixogram.model.Like;
import com.social.imageApp.Pixogram.model.Media;
import com.social.imageApp.Pixogram.services.MyMediaService;

@RestController
@CrossOrigin(value="*")
@RequestMapping(value="/media")
public class MediaDetailController {

	@Autowired
	MyMediaService myMediaService;
	
	@PostMapping(path="/getMedia")
	public Media getMediaDetails(@RequestBody Media media) {
		media = myMediaService.getMediaDetails(media);
		System.out.println(media);
		return media;
	}
	
	@PostMapping(path="/getComments")
	public List<Comment> getComments(@RequestBody Media media) {
		List<Comment> commentList = myMediaService.getComments(media);
		return commentList;
	}

	@PostMapping(path="/saveComment")
	public Comment saveComment(@RequestBody Comment comment) {
		comment = myMediaService.saveComment(comment);
		return comment;
	}
	
	@PostMapping(path="/like")
	public Like setLike(@RequestBody Like like) {
		System.out.println(like.getLike());
		like = myMediaService.setLike(like);
		
		return like;
	}
}
