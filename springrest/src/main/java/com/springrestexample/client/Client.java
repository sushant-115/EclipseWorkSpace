package com.springrestexample.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.springrestexample.domain.User;
import com.springrestexample.util.JsonUtil;

public class Client {

	public static void main(String[] args) {
		String url="http://localhost:8080/springrest/getUserInfo/{userId}";
		RestTemplate restTemplate =new RestTemplate();
Map<String,Object> map=new HashMap<String,Object>();
map.put("userId", 101);
String jsonUser=restTemplate.getForObject(url, String.class, map);
System.out.println(jsonUser);
User user=JsonUtil.convertJsonToJava(User.class,jsonUser);
System.out.println(user.getEmail()+"\t"+user.getMobile());
	}

}
