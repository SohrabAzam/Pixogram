package com.social.imageApp.Pixogram.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.social.imageApp.Pixogram.model.Comment;

public interface CommentDao extends CrudRepository<Comment, Integer> {

	List<Comment> findAllBymediaId(int id);

}
