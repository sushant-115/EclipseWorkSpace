package com.springrestexample.util;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.springrestexample.domain.User;

public class JsonUtil {
	private static ObjectMapper mapper;
	static{
		mapper=new ObjectMapper();
	}
public static String covertJavaToJson(User user){
	String json = "";
	try {
		json=mapper.writeValueAsString(user);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return json;
}
public static <T> T convertJsonToJava(Class<T> cls,String json){
	T response=null;
	try {
	response=mapper.readValue(json, cls);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return response;
}
}
