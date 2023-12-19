package com.library.service;

import com.library.entity.User;

public interface UserService {
	
	User findByUserName(String username);
	
	User saveUser(User user);
	
	boolean existsByUsernameAndPassword(String username, String password);
}
