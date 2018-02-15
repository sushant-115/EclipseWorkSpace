package com.messaging.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.messaging.dao.MessagingDAOImpl;
import com.messaging.entity.MessageUser;

public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
     public MessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uName=request.getParameter("uName");
MessagingDAOImpl dao=new MessagingDAOImpl();
List<MessageUser> list=dao.getMessage(uName);
Date date =new Date();  
request.setAttribute("list", list);
request.getRequestDispatcher("message.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uName=request.getParameter("uname");
	String toName=request.getParameter("name");
	String message=request.getParameter("message");
	if(uName!=null&&!"".equals(uName)&&toName!=null&&!"".equals(toName)&&message!=null&&!"".equals(message)){
		MessageUser user=new MessageUser();
		MessagingDAOImpl dao=new MessagingDAOImpl();
		
		user.setSenderUname(uName);
		user.setuName(toName);
		user.setMessage(message);
		user.setCreateDate(new Date());
		String status=dao.sendMessage(user);
		request.setAttribute("status", status);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	}

}
