package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.UserService;
import com.qa.business.service.GameService;
import com.qa.persistence.domain.User;
import com.qa.persistence.domain.Game;
import com.qa.util.JSONUtil;

@Path("/game")
public class GameEndpoint {
	
	@Inject
	private GameService service;

	
	@Inject
	private JSONUtil jsonOb;
		
	@Path("/getAllGames")
	@GET
	@Produces({ "application/json" })
	public String getAllGames() {
		return service.getAllGames();
	}

	@Path("/createGame")
	@POST
	@Produces({ "application/json" })
	public String addGame(String t) {
		return service.createGame(t);
	}

	@Path("/deleteGame/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteGame(@PathParam("id") Long id) {
		return service.deleteGame(id);
	}
	
	@Path("/getGame/{id}")
	@GET
	@Produces({ "application/json" })
	public String getGame(@PathParam("id") Long id) {
		return service.getGame(id);
	}
	
	@Path("/updateGame")
	@PUT
	@Produces({ "application/json" })
	public String updateGame(String t) {
		Game tObj= jsonOb.getObjectForJSON(t, Game.class);
		return service.updateGame(tObj);
	}

	public void setService(GameService service) {
		this.service = service;
	}

}
