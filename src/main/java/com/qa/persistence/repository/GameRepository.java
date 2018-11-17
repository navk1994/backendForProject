package com.qa.persistence.repository;

import com.qa.persistence.domain.Game;

public interface GameRepository {

	String getAllGames();
	String createGame(String cr);
	String getGame(long id);
	String deleteGame(long id);
	String updateGame(Game t);
}