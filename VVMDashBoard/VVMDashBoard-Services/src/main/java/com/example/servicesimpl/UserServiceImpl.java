package com.example.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.UserRepository;
import com.example.entities.User;
import com.example.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User getUser(int id) {
		User user = userRepository.findById(id).get();
		return user;
	}

}
