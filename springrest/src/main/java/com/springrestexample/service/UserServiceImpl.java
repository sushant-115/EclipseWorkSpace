package com.springrestexample.service;

import org.springframework.stereotype.Service;

import com.springrestexample.domain.User;
import com.springrestexample.util.JsonUtil;
@Service
public class UserServiceImpl implements UserService{

	@Override
	public String getUserDetails(Integer uid) {
		String jsonUser="";
		if(uid!=null&&uid.equals(101)){
			User user=new User();
			user.setName("sushant");
			user.setUid(101);
			user.setEmail("abc@gmail.com");
			user.setMobile("999888777");
			jsonUser=JsonUtil.covertJavaToJson(user);
		}
		
		return jsonUser;
	}

}
