package com.qa.business.service;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Game;
import com.qa.persistence.repository.GameRepository;


@Default
public class GameServiceImpl implements GameService {

	@Inject
	private GameRepository repo;

	public String getAllGames() {
		return repo.getAllGames();
	}

	public String createGame(String t) {
		return repo.createGame(t);
	}

	@Override
	public String deleteGame(long id) {
		return repo.deleteGame(id);
	}

	@Override
	public String getGame(long id) {
		return repo.getGame(id);
	}

	@Override
	public String updateGame(Game t) {
		return repo.updateGame(t);
	}

	
	public void setRepo(GameRepository repo) {
		this.repo = repo;
	}


	
}
