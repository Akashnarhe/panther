package com.example.services;

import java.util.List;

import com.example.tos.UserCto;

public interface UserService {
	UserCto getUser(int id);
	List<UserCto> getAllUsers();
	void saveUser(UserCto userCto);
	void deleteUser(int id);
}
