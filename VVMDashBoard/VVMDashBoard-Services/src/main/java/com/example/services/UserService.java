package com.example.services;

import com.example.tos.UserCto;

public interface UserService {
	UserCto getUser(int id);
	void saveUser(UserCto userCto);
	void deleteUser(int id);
}
