package com.social.imageApp.Pixogram.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.imageApp.Pixogram.dao.AccountDao;
import com.social.imageApp.Pixogram.dao.ActivityDao;
import com.social.imageApp.Pixogram.model.Activity;
import com.social.imageApp.Pixogram.model.User;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDao accountDao;
	
	@Autowired
	ActivityDao activityDao;
	
	Activity activity = new Activity();
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
	
	public User registerUser(User user) {
		return accountDao.save(user);
	}

	public User checkUserName(String username) {
		return accountDao.findByUsername(username);
	}

	public User checkUser(User user) {
		User user1 = accountDao.findByUsername(user.getUsername());
		if(user.getPassword().equals(user1.getPassword())) {
			return user1;
		}
		else {
			return null;
		}
	}

	public User updateUser(User user) {
		
		activity.setActivity("Updated User Details");
		activity.setUserId(user.getUserId());
		Date date = new Date();
		activity.setDate(sdf1.format(date));
		activity.setTime(sdf2.format(date));
		
		activityDao.save(activity);
		
		return accountDao.save(user);
	}

	public List<User> fetchUsers() {
		List<User> userList = (List<User>) accountDao.findAll();
		return userList;
	}

	public User loadUserById(int userId) {
		return accountDao.findByuserId(userId);
	}

	public List<Activity> getActivities(User user) {
		return activityDao.findAllByUserId(user.getUserId());
	}

}
