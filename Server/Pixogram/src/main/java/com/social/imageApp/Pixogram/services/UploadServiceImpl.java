package com.social.imageApp.Pixogram.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.imageApp.Pixogram.dao.AccountDao;
import com.social.imageApp.Pixogram.dao.ActivityDao;
import com.social.imageApp.Pixogram.dao.UploadDao;
import com.social.imageApp.Pixogram.model.Activity;
import com.social.imageApp.Pixogram.model.Media;
import com.social.imageApp.Pixogram.model.User;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	UploadDao uploadDao;
	
	@Autowired
	ActivityDao activityDao;
	
	@Autowired
	AccountDao accountDao;
	
	private Activity activity = new Activity();
	private SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
	
	public Media saveSingleMedia(Media media) {
		
		User user = accountDao.findByuserId(media.getUserId());
		user.setImageCount(user.getImageCount()+1);
		accountDao.save(user);
		
		activity.setActivity("Uploaded " + media.getTitle());
		activity.setUserId(media.getUserId());
		Date date = new Date();
		activity.setDate(sdf1.format(date));
		activity.setTime(sdf2.format(date));
		activityDao.save(activity);
		
		return uploadDao.save(media);
	}

}
