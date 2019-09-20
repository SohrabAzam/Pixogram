package com.social.imageApp.Pixogram.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.imageApp.Pixogram.dao.AccountDao;
import com.social.imageApp.Pixogram.dao.ActivityDao;
import com.social.imageApp.Pixogram.dao.FollowDao;
import com.social.imageApp.Pixogram.model.Activity;
import com.social.imageApp.Pixogram.model.Followers;
import com.social.imageApp.Pixogram.model.User;

@Service
public class FollowServiceImpl implements FollowService {

	@Autowired
	FollowDao followDao;
	
	@Autowired
	ActivityDao activityDao;
	
	@Autowired
	AccountDao accountDao;
	
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
	
	public List<Followers> fetchAll(User user) {
		return followDao.findAllByUserId(user.getUserId());
	}

	public Followers getFollower(int followerId, int userId) {
		List<Followers> followerList =  followDao.findAllByFollowerId(followerId);
		
		for(Followers f : followerList) {
			if(f.getUserId() == userId) {
				return f;
			}
		}
		
		return null;
	}

	public Followers createFollower(Followers follower) {
		Activity activity = new Activity();
		activity.setActivity("Followed " + follower.getFollowerName());
		activity.setUserId(follower.getUserId());
		Date date = new Date();
		activity.setDate(sdf1.format(date));
		activity.setTime(sdf2.format(date));
		
		activityDao.save(activity);
		
		User user = accountDao.findByuserId(follower.getUserId());
		
		Followers follower1 = new Followers();
		follower1.setUserId(follower.getFollowerId());
		follower1.setFollowerId(follower.getUserId());
		follower1.setFollowerName(user.getUsername());
		follower1.setFollower('Y');
		followDao.save(follower1);
		
		return followDao.save(follower);
	}

	public Followers follow(Followers follower1) {
		Activity activity = new Activity();
		activity.setActivity("Followed " + follower1.getFollowerName());
		activity.setUserId(follower1.getUserId());
		Date date = new Date();
		activity.setDate(sdf1.format(date));
		activity.setTime(sdf2.format(date));
		activityDao.save(activity);
		
		Followers follower = followDao.findByUserIdandFollowerId(follower1.getFollowerId(),follower1.getUserId());
		follower.setFollower('Y');
		followDao.save(follower);
		
		
		return followDao.save(follower1);
	}

	public Followers unfollow(Followers follower) {
		
		Activity activity = new Activity();
		activity.setActivity("Unfollowed " + follower.getFollowerName());
		activity.setUserId(follower.getUserId());
		Date date = new Date();
		activity.setDate(sdf1.format(date));
		activity.setTime(sdf2.format(date));
		
		Followers follower1 = followDao.findByUserIdandFollowerId(follower.getFollowerId(),follower.getUserId());
		follower1.setFollower('N');
		followDao.save(follower1);
		
		activityDao.save(activity);
		return followDao.save(follower);
	}

}
