package com.social.imageApp.Pixogram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.social.imageApp.Pixogram.model.Activity;

public interface ActivityDao extends CrudRepository<Activity, Integer> {

	List<Activity> findAllByUserId(int userId);

}
