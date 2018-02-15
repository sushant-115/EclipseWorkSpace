package com.messaging.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.messaging.dao.MessagingDAOImpl;
import com.messaging.entity.User;

public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uname=request.getParameter("un");
	String email=request.getParameter("email");
	String mobile=request.getParameter("mn");
	String dob=request.getParameter("dob");
	String password=request.getParameter("password");
	String repass=request.getParameter("repass");
	String status="User registraion Failed !Please try again";
	if(!repass.equals(password)){
		status="Password not matched";
		request.setAttribute("status", status);
		return;
	}
	User user= new User();
	user.setUname(uname);
	user.setEmail(email);
	user.setMobile(mobile);
	user.setPassword(password);
	SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
	try {
		user.setDob(format.parse(dob));
	} catch (ParseException e) {
		status="Date format not matched";
		request.setAttribute("status", status);
	}
	MessagingDAOImpl dao=new MessagingDAOImpl();
	int count=dao.singup(user);
	if(count==1){
		status="Registration succesfull";
		request.setAttribute("status", status);
	}else{
		status="Registration failed";
		request.setAttribute("status",status);
	}
	request.getRequestDispatcher("Signup.jsp").forward(request, response);
		}

}
