package com.qa.persistence.repository;

import com.qa.persistence.domain.Game;

public interface TraineeRepository {

	String getAllGames();
	String createGame(String cr);
	String getGame(long id);
	String deleteGame(long id);
	String updateGame(Game t);
}