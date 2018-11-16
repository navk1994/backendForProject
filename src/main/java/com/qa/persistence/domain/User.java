package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class User {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private long userID;
	private String username;
	private String password;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "gameID")
	private List<Game> games = new ArrayList<>();
	
	
	public User() {
		
	}
	
	public User(int userID, String username, String password, List<Game> games) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.games = games;
	}

	public User(String username, List<Game> games) {
		this.username = username;
		this.games = games;
	}

	
	
	public long getUserID() {
		return userID;
	}
	public void setUserID(long userID) {
		this.userID = userID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Game> getGames() {
		return games;
	}
	public void setTrainees(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Classroom [classroomId=" + userID + ", trainer=" + username + ", trainees=" + games + "]";
	}
	
}
