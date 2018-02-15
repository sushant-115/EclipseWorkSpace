package com.firstservlet.restful;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJson {

	public static void main(String[] args) {
ObjectMapper mapper =new ObjectMapper();
String json =null;
try {
User user=new User();
user.setMobile("9999");
user.setName("sushant");

	json=mapper.writeValueAsString(user);
	System.out.println(json);
} catch (JsonProcessingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
User jsonToJava=null;
try {
	jsonToJava = mapper.readValue(json, User.class);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(jsonToJava.getMobile()+"\t"+jsonToJava.getName());
	}

}
