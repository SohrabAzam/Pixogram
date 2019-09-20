package com.social.imageApp.Pixogram.dao;

import org.springframework.data.repository.CrudRepository;

import com.social.imageApp.Pixogram.model.Media;

public interface UploadDao extends CrudRepository<Media, Integer>{

}
