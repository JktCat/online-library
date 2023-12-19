package com.library.service.impl;

import org.springframework.stereotype.Service;

import com.library.entity.User;
import com.library.repository.UserRepository;
import com.library.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public User findByUserName(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		user.setRole("USER");
		return userRepo.save(user);
	}

	@Override
	public boolean existsByUsernameAndPassword(String username, String password) {
		return userRepo.existsByUsernameAndPassword(username, password);
	}

}
