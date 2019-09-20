package com.social.imageApp.Pixogram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.social.imageApp.Pixogram.model.Comment;
import com.social.imageApp.Pixogram.model.Media;

public interface MyMediaDao extends CrudRepository<Media, Integer> {

	List<Media> findAllByUserId(int userId);

	Media findByMediaId(int mediaId);

	List<Comment> findAllBymediaId(int mediaId);

}
