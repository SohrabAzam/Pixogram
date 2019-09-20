package com.social.imageApp.Pixogram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.social.imageApp.Pixogram.model.Blocked;

public interface BlockedDao extends CrudRepository<Blocked, Integer> {

	List<Blocked> findAllByUserId(int userId);

	Blocked findByUserIdAndBlockedId(int userId, int blockedId);
	
	
}
