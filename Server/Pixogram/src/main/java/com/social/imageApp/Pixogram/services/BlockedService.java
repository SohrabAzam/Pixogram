package com.social.imageApp.Pixogram.services;

import java.util.List;

import com.social.imageApp.Pixogram.model.Blocked;
import com.social.imageApp.Pixogram.model.User;

public interface BlockedService {

	List<Blocked> getAllBlocked(User user);

	Blocked block(Blocked blocked);

	Blocked unblock(Blocked blocked);

}
