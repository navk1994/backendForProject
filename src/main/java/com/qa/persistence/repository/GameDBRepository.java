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
public class GameDBRepository implements GameRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil jsonOb;
	
	public String getAllGames() {
		Query query = manager.createQuery("Select t FROM Game t");
		Collection<Game> games = (Collection<Game>) query.getResultList();
		return jsonOb.getJSONForObject(games);
	}
	
	@Transactional(REQUIRED)
	public String createGame(String trainee) {
		Game aGame = jsonOb.getObjectForJSON(trainee, Game.class);
		manager.persist(aGame);
		return "{\"message\": \"game has been sucessfully added\"}";
	}
	
	@Transactional(REQUIRED)
	public String deleteGame(long id) {
		Game gameInDB = findGame(id);
		if (gameInDB != null) {
			manager.remove(gameInDB);
		}
		return "{\"message\": \"game sucessfully deleted\"}";
	}

	public String getGame(long id) {
		Game gameInDB = findGame(id);
		return jsonOb.getJSONForObject(gameInDB);
	}
	
	private Game findGame(long id)
	{
		return manager.find(Game.class, id);
	}
	
	@Transactional(REQUIRED)
	public String updateGame(Game g) {
		Game gameInDB = findGame(g.getGameId());
		gameInDB.setGameTitle(g.getGameTitle());
		gameInDB.setGamePlatform(g.getGamePlatform());
		gameInDB.setGameGenre(g.getGameGenre());
		gameInDB.setGameId(g.getGameId());
		return "{\"message\": \"game has been sucessfully updated\"}";
	}
	
	
	


	public void setManager(EntityManager manager) {
		this.manager = manager;
	}


		
}
