package com.bankingApplication.service;

import com.bankingApplication.entities.User;

public interface UserService {
	
	User findByUsername(String username);
	User findByEmail(String email);
	boolean checkUserExists(String username, String email);
	boolean checkUsernameExists(String username);
	boolean checkEmailExists(String email);
	void save(User user);

}
