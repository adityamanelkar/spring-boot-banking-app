package com.bankingApplication.service.DataAccess;

import org.springframework.data.repository.CrudRepository;

import com.bankingApplication.entities.User;

public interface UserDataAccess extends CrudRepository<User, Long> {
	
	User findByUsername(String username);
	User findByEmail(String email);
}
