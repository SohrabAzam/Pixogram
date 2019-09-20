package com.social.imageApp.Pixogram.services;

import java.util.List;

import com.social.imageApp.Pixogram.model.Followers;
import com.social.imageApp.Pixogram.model.User;

public interface FollowService {

	List<Followers> fetchAll(User user);

	Followers getFollower(int followerId, int userId);

	Followers createFollower(Followers follower);

	Followers follow(Followers follower1);

	Followers unfollow(Followers follower);

}
