package com.social.imageApp.Pixogram.services;

import java.util.List;

import com.social.imageApp.Pixogram.model.Activity;
import com.social.imageApp.Pixogram.model.User;

public interface AccountService {

	public User registerUser(User user);

	public User checkUserName(String username);

	public User checkUser(User user);

	public User updateUser(User user);

	public List<User> fetchUsers();

	public User loadUserById(int userId);

	public List<Activity> getActivities(User user);
}
