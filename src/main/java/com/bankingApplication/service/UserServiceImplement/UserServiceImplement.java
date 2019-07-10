package com.bankingApplication.service.UserServiceImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingApplication.entities.User;
import com.bankingApplication.service.UserService;
import com.bankingApplication.service.DataAccess.UserDataAccess;

@Service
public class UserServiceImplement implements UserService {
	
	@Autowired
	private UserDataAccess userDataAccess;
	
	public void save(User user) {
		userDataAccess.save(user);
	}
	
	public User findByUsername(String username) {
		return userDataAccess.findByUsername(username);
	}
	
	public User findByEmail(String email) {
		return userDataAccess.findByEmail(email);
	}
	
	public boolean checkUserExists(String username, String email) {
		if(checkUsernameExists(username) || checkEmailExists(email)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean checkUsernameExists(String username) {
		System.out.println(findByUsername(username).getUsername());
		if(null != findByUsername(username)) {
			return true;
		}
		return false;
	}
	
	public boolean checkEmailExists(String email) {
		if(null != findByEmail(email)) {
			return true;
		}
		return false;
	}

}
