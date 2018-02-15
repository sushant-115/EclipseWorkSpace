package com.jerseyutil.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jerseyutil.domain.Book;

public class JsonUtil {
	public static String convertJavaToJson(Object obj){
		String jsonStr="";
					ObjectMapper objectMapper =new ObjectMapper();
			
					try{
	jsonStr=objectMapper.writeValueAsString(obj);
	System.out.println(jsonStr);
	}catch(JsonProcessingException e){
	System.out.println("Error occured during converting to java to json");
		}		
		return jsonStr;
	}
	public static <T> T convertJsonToJava(String jsonStr,Class<T> cls){
		System.out.println(jsonStr);
		T response =null;
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			response=objectMapper.readValue(jsonStr, cls);
		} catch (JsonParseException e) {
			e.printStackTrace();
			} catch (JsonMappingException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			}
		return response;
		
	}
	

}
