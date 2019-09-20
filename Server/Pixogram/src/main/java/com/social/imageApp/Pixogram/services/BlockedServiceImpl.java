package com.social.imageApp.Pixogram.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.social.imageApp.Pixogram.dao.BlockedDao;
import com.social.imageApp.Pixogram.model.Blocked;
import com.social.imageApp.Pixogram.model.User;

@Service
public class BlockedServiceImpl implements BlockedService {

	@Autowired
	BlockedDao blockedDao;
	
	public List<Blocked> getAllBlocked(User user) {
		return blockedDao.findAllByUserId(user.getUserId());
	}

	public Blocked block(Blocked blocked) {
		Blocked block1 = blockedDao.findByUserIdAndBlockedId(blocked.getUserId(),blocked.getBlockedId());
		if(block1 == null) {
			return blockedDao.save(blocked);
		}
		else {
			return null;
		}
	}

	public Blocked unblock(Blocked blocked) {
		System.out.println(blocked);
		blockedDao.deleteById(blocked.getId());
		return blocked;
	}

}
