package com.social.imageApp.Pixogram.services;

import java.util.List;

import com.social.imageApp.Pixogram.model.Comment;
import com.social.imageApp.Pixogram.model.Like;
import com.social.imageApp.Pixogram.model.Media;
import com.social.imageApp.Pixogram.model.User;

public interface MyMediaService {

	List<Media> getAllMedia(User user);

	Media getMediaDetails(Media media);

	List<Comment> getComments(Media media);

	Comment saveComment(Comment comment);

	Like setLike(Like like);

}
