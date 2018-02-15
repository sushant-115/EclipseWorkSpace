package com.firstservlet.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("json")
public class JsonExample {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/searchUser")
	public User searchUser(){
		
			User user=new User();
			user.setName("name");
			user.setMobile("mobile");
			return user;
	
	}

}
