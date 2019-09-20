package com.social.imageApp.Pixogram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.social.imageApp.Pixogram.model.Like;

public interface LikeDao extends CrudRepository<Like, Integer> {

	List<Like> findAllBymediaId(int mediaId);
	
}
