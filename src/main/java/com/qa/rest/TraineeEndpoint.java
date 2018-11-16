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

@Path("/trainee")
public class TraineeEndpoint {
	
	@Inject
	private GameService service;

	
	@Inject
	private JSONUtil jsonOb;
	
	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllGames();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String addTrainee(String t) {
		return service.createGame(t);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Long id) {
		return service.deleteGame(id);
	}
	
	@Path("/getTrainee/{id}")
	@GET
	@Produces({ "application/json" })
	public String getTrainee(@PathParam("id") Long id) {
		return service.getGame(id);
	}
	
	@Path("/updateTrainee")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(String t) {
		Game tObj= jsonOb.getObjectForJSON(t, Game.class);
		return service.updateGame(tObj);
	}

	public void setService(GameService service) {
		this.service = service;
	}

}
