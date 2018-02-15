package com.user.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.user.config.MyBeans;
import com.user.dao.UserDAO;
import com.user.pojo.User;

public class ClientApp {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(MyBeans.class);
	UserDAO userDao=context.getBean("userDao", UserDAO.class);
User user=new User();
user.setUserId(101);
user.setFirstName("sushant");
user.setLastName("kumar");
user.setEmail("sushant@outlook.com");
user.setMobile("999888777");
System.out.println(userDao.createUser(user));
	}

}
