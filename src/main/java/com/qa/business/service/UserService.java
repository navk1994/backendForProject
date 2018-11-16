package com.qa.business.service;

import com.qa.persistence.domain.User;

public interface UserService {

	String getAllUsers();
	String createUser(String cr);
	String getUser(long id);
	String deleteUser(long id);
	String updateUser(User cr);
	
}
