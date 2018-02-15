package com.sushant.client;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sushant.bean.MyBeans;
import com.sushant.dao.User;
import com.sushant.service.SmartQuizService;

public class SmartQuizClient{

	

	public static void main(String[] args)  {
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		Date dob = null;
		User user=new User();
	ApplicationContext context=new AnnotationConfigApplicationContext(MyBeans.class);
	SmartQuizService quizService=context.getBean("smartQuizServiceImpl", SmartQuizService.class);
	Scanner sc=new Scanner(System.in);
	System.out.println("-----Choice-----");
	System.out.println("1.SignUp\n2.ForgotPassword\n3.SearchUserDetails");
	int choice=sc.nextInt();
	boolean b=true;
	switch(choice){
	case 1:
		System.out.println("Enter username");
		user.setUsername(sc.next());
		System.out.println("Enter password");
		String pwd=sc.next();
		while(b){
		System.out.println("Repeat Password");
		String pwd1=sc.next();
		if(!pwd.equals(pwd1))
			System.out.println("Password not match");
		if(pwd.equals(pwd1))
			b=false;
		}
		user.setPassword(pwd);
		System.out.println("Date Of Birth");
		try {
		dob=sdf.parse(sc.next());
		} catch (ParseException e) {
		System.out.println("Invalid date format(DD/MM/YYYY)");
		}
	System.out.println("Enter email");
	user.setUserEmail(sc.next());
	System.out.println("Enter mobile no");
	user.setUserMobile(sc.next());
	String status=null;
		try {
			status=quizService.insertUser(user);
		} catch (SQLException e) {
			status="SignUp failed!please try again";
		}
System.out.println(status);
break;
	case 2:
		System.out.println("Enetr username");
		String username1=sc.next();
		System.out.println("Enter new Password");
		String pwd1=sc.next();
		boolean k=true;
		while(k){
		System.out.println("Re-enter password");
		String pwd2=sc.next();
		if(pwd1.equals(pwd2))
			k=false;
		System.out.println("Password not matched");
		}
		try {
			quizService.updatePassword(username1, pwd1);
		} catch (SQLException e1) {
		System.out.println("Username not found");	
		}
		break;
	case 3:
		System.out.println("Enter username");
		String username=sc.next();
		String status2="User not found";
		try {
		Set<String> list=	quizService.searchUser(username);
		for(String s:list){
			System.out.println(s);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		break;
	}
	}

}
