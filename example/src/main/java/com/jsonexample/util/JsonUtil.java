package com.jsonexample.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	public static String convertJavaToJson(Object obj){
		String json="{}";
		ObjectMapper objectMapper=new ObjectMapper();
try {
	json =objectMapper.writeValueAsString(obj);
} catch (JsonProcessingException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
return json;
	}
public static <T> T convertJsonToJava(String jsonStr,Class<T> cls){
	T response=null;
	ObjectMapper objectMapper=new ObjectMapper();
	try {
		response=objectMapper.readValue(jsonStr, cls);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return response;
}
}
