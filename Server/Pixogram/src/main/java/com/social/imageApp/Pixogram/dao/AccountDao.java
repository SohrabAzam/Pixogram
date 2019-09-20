package com.social.imageApp.Pixogram.dao;

import org.springframework.data.repository.CrudRepository;

import com.social.imageApp.Pixogram.model.User;

public interface AccountDao extends CrudRepository<User, Integer>{

	User findByUsername(String username);

	User findByuserId(int userId);
	
}
