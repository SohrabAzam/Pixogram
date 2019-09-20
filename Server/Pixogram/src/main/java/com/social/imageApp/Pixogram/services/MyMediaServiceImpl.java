package com.social.imageApp.Pixogram.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.imageApp.Pixogram.dao.ActivityDao;
import com.social.imageApp.Pixogram.dao.CommentDao;
import com.social.imageApp.Pixogram.dao.LikeDao;
import com.social.imageApp.Pixogram.dao.MyMediaDao;
import com.social.imageApp.Pixogram.model.Activity;
import com.social.imageApp.Pixogram.model.Comment;
import com.social.imageApp.Pixogram.model.Like;
import com.social.imageApp.Pixogram.model.Media;
import com.social.imageApp.Pixogram.model.User;

@Service
public class MyMediaServiceImpl implements MyMediaService {

	@Autowired
	MyMediaDao myMediaDao;

	@Autowired
	CommentDao commentDao;

	@Autowired
	LikeDao likeDao;

	@Autowired
	ActivityDao activityDao;

	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");

	public List<Media> getAllMedia(User user) {
		return myMediaDao.findAllByUserId(user.getUserId());
	}

	public Media getMediaDetails(Media media) {
		return myMediaDao.findByMediaId(media.getMediaId());
	}

	public List<Comment> getComments(Media media) {
		return commentDao.findAllBymediaId(media.getMediaId());
	}

	public Comment saveComment(Comment comment) {
		Activity activity = new Activity();
		activity.setActivity("Commented " + comment.getComment() + " on " + comment.getMediaId());
		activity.setUserId(comment.getUserId());
		Date date = new Date();
		activity.setDate(sdf1.format(date));
		activity.setTime(sdf2.format(date));
		activityDao.save(activity);

		Media media = myMediaDao.findByMediaId(comment.getMediaId());
		media.setNumberOfComments(media.getNumberOfComments() + 1);
		myMediaDao.save(media);

		return commentDao.save(comment);
	}

	public Like setLike(Like like) {
		
	
		
		if(like.getLike()=='Y')
		{
			boolean liked = false;
		List<Like> likeList = likeDao.findAllBymediaId(like.getMediaId());
			/*
			 * for (Like like1 : likeList) { if (like1.getUserId() == like.getUserId()) {
			 * liked = true;
			 * 
			 * break; } }
			 */

		
			System.out.println("Likes..........................");
		if (liked == true) {
			return null;
		} else {
			
			Activity activity = new Activity();
			activity.setActivity("Liked " + like.getMediaId());
			activity.setUserId(like.getUserId());
			Date date = new Date();
			activity.setDate(sdf1.format(date));
			activity.setTime(sdf2.format(date));
			activityDao.save(activity);

			
			Media media = myMediaDao.findByMediaId(like.getMediaId());
			media.setLikes(media.getLikes() + 1);
			myMediaDao.save(media);

			liked=true;
			//return likeDao.save(like);
		}
	}
	
	else
	{
		boolean disliked = false;
		List<Like> likeList = likeDao.findAllBymediaId(like.getMediaId());
			/*
			 * for (Like like1 : likeList) { if (like1.getUserId() == like.getUserId()) {
			 * disliked = true;
			 * 
			 * break; } }
			 */

		System.out.println("DisLikes..........................");
		if (disliked == true) {
			System.out.println("null");
			return null;
		} else {
			
			Activity activity = new Activity();
			activity.setActivity("DisLiked " + like.getMediaId());
			activity.setUserId(like.getUserId());
			Date date = new Date();
			activity.setDate(sdf1.format(date));
			activity.setTime(sdf2.format(date));
			activityDao.save(activity);

			
			Media media = myMediaDao.findByMediaId(like.getMediaId());
			System.out.println("Before Unlike...................");
			media.setUnlikes(media.getUnlikes()+1);
			System.out.println(media.getUnlikes()+1);
			myMediaDao.save(media);
			System.out.println("After Unlike..................."+media);
			disliked=true;

			//return likeDao.save(like);
		}
	}
		return likeDao.save(like);
	}
}
