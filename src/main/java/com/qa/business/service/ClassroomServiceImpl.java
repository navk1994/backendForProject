package com.qa.business.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.User;
import com.qa.persistence.repository.ClassroomRepository;


@Default
public class ClassroomServiceImpl implements UserService {

	@Inject
	private ClassroomRepository repo;

	public String getAllUsers() {
		return repo.getAllUsers();
	}

	public String createUser(String cr) {
		return repo.createUser(cr);
	}

	@Override
	public String deleteUser(long id) {
		return repo.deleteUser(id);
	}

	@Override
	public String getUser(long id) {
		return repo.getUser(id);
	}

	@Override
	public String updateUser(User cr) {
		return repo.updateUser(cr);
	}

	
	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}


	
}
