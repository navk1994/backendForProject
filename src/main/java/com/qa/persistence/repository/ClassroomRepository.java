package com.qa.persistence.repository;

import com.qa.persistence.domain.User;

public interface ClassroomRepository {

	String getAllUsers();
	String createUser(String cr);
	String getUser(long id);
	String deleteUser(long id);
	String updateUser(User cr);
}