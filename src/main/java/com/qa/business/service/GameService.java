package com.qa.business.service;

import com.qa.persistence.domain.Game;

public interface GameService {

	String getAllGames();
	String createGame(String cr);
	String getGame(long id);
	String deleteGame(long id);
	String updateGame(Game t);
	
}
