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
import com.qa.persistence.domain.User;
import com.qa.util.JSONUtil;

@Path("/user")
public class UserEndpoint {
	
	@Inject
	private UserService service;

	
	@Inject
	private JSONUtil jsonOb;
	
	@Path("/getAllUsers")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllUsers();
	}

	@Path("/createUser")
	@POST
	@Produces({ "application/json" })
	public String addClassroom(String cr) {
		return service.createUser(cr);
	}

	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroom(@PathParam("id") Long id) {
		return service.deleteUser(id);
	}
	
	@Path("/getUser/{id}")
	@GET
	@Produces({ "application/json" })
	public String getClassroom(@PathParam("id") Long id) {
		return service.getUser(id);
	}
	
	@Path("/updateUser")
	@PUT
	@Produces({ "application/json" })
	public String updateClassroom(String cr) {
		User crObj= jsonOb.getObjectForJSON(cr, User.class);
		return service.updateUser(crObj);
	}

	public void setService(UserService service) {
		this.service = service;
	}

}
