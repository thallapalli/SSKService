package com.ssk.model.service;

import com.ssk.model.entities.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
