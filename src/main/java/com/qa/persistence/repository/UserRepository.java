package com.qa.persistence.repository;

import com.qa.persistence.domain.User;

public interface UserRepository {

	String getAllUsers();
	String createUser(String cr);
	String getUser(long id);
	String deleteUser(long id);
	String updateUser(User cr);
}