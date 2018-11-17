package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class UserDBRepository implements UserRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;
	
	public String getAllUsers() {
		Query query = manager.createQuery("Select cr FROM User cr");
		Collection<User> users = (Collection<User>) query.getResultList();
		return jsonOb.getJSONForObject(users);
	}
	
	@Transactional(REQUIRED)
	public String createUser(String user) {
		User aUser = jsonOb.getObjectForJSON(user, User.class);
		manager.persist(aUser);
		return "{\"message\": \"user has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteUser(long id) {
		User userInDB = findUser(id);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"classroom sucessfully deleted\"}";
	}

	public String getUser(long id) {
		User classroomInDB = findUser(id);
		return jsonOb.getJSONForObject(classroomInDB);
	}
	
	@Transactional(REQUIRED)
	public String updateUser(User cr) {
		User classroomInDB = findUser(cr.getUserID());
		classroomInDB.setUsername(cr.getUsername());
		classroomInDB.setTrainees(cr.getGames());
		return "{\"message\": \"user has been sucessfully updated\"}";
	}
	
	
	private User findUser(long id) {
		return manager.find(User.class, id);
	}


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}



		
}
