package com.social.imageApp.Pixogram.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.social.imageApp.Pixogram.model.Followers;

public interface FollowDao extends CrudRepository<Followers, Integer>{

	List<Followers> findAllByUserId(int userId);

	List<Followers> findAllByFollowerId(int followerId);

	@Query("SELECT f FROM Followers f WHERE f.userId = :uid and f.followerId = :fid")
	Followers findByUserIdandFollowerId(@Param("uid") int userId,@Param("fid") int followerId);

}
