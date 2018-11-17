package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

@Entity
public class Game {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long gameID;
	
	private String gameTitle;
	private String gamePlatform;
	private String gameGenre;
	
	
	//@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "classroomid")
	private long userID;
	

	
	
	public Game() {
		
	}
	
	public Game(long userID, String gameTitle, String gamePlatform, String gameGenre) {
		this.gameTitle = gameTitle;
		this.gamePlatform = gamePlatform;
		
		this.userID = userID;
		this.gameGenre = gameGenre;
	}

	public Game(String gameTitle, String gamePlatform) {
		this.gameTitle = gameTitle;
		this.gamePlatform = gamePlatform;
	}
	
	public long getGameId() {
		return gameID;
	}

	public void setGameId(long traineeId) {
		this.gameID = traineeId;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public String getGamePlatform() {
		return gamePlatform;
	}

	public void setGamePlatform(String gamePlatform) {
		this.gamePlatform = gamePlatform;
	}
	
	public String getGameGenre() {
		return gameGenre;
	}

	public void setGameGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}


	

	
	

	@Override
	public String toString() {
		return "Game [traineeId=" + gameID + ", fName=" + gameTitle + ", lName=" + gamePlatform + ", classroomId="
				+ gameID + "]";
	}



	
	
}
