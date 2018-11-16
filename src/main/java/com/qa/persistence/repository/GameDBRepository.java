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
import com.qa.persistence.domain.Game;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class GameDBRepository implements TraineeRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;
	
	public String getAllGames() {
		Query query = manager.createQuery("Select t FROM Trainee t");
		Collection<Game> trainees = (Collection<Game>) query.getResultList();
		return jsonOb.getJSONForObject(trainees);
	}
	
	@Transactional(REQUIRED)
	public String createGame(String trainee) {
		Game aTrainee = jsonOb.getObjectForJSON(trainee, Game.class);
		manager.persist(aTrainee);
		return "{\"message\": \"game has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteGame(long id) {
		Game traineeInDB = findGame(id);
		if (traineeInDB != null) {
			manager.remove(traineeInDB);
		}
		return "{\"message\": \"game sucessfully deleted\"}";
	}

	public String getGame(long id) {
		Game traineeInDB = findGame(id);
		return jsonOb.getJSONForObject(traineeInDB);
	}
	
	private Game findGame(long id)
	{
		return manager.find(Game.class, id);
	}
	
	@Transactional(REQUIRED)
	public String updateGame(Game t) {
		Game traineeInDB = findGame(t.getGameId());
		traineeInDB.setGameTitle(t.getGameTitle());
		traineeInDB.setGamePlatform(t.getGamePlatform());
		traineeInDB.setGameGenre(t.getGameGenre());
		traineeInDB.setGameId(t.getGameId());
		return "{\"message\": \"game has been sucessfully updated\"}";
	}
	
	
	


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


		
}
