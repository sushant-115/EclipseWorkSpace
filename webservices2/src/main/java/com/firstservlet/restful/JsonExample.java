package com.firstservlet.restful;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Path("json")
public class JsonExample {
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/searchUser")
	public String searchUser(){
		ObjectMapper mapper =new ObjectMapper();
			User user=new User();
			user.setName("name");
			user.setMobile("mobile");
			String json=null;
			try {
				json = mapper.writeValueAsString(user);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return json;
	
	}

}
