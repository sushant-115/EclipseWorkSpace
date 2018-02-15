package com.messaging.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.messaging.dao.MessagingDAOImpl;
import com.messaging.entity.User;

public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uname=request.getParameter("uname");
	String email=request.getParameter("email");
	String mobile=request.getParameter("mobile");
	String status="User not found";
	if(null!=uname&&!"".equals(uname)){
		MessagingDAOImpl dao=new MessagingDAOImpl();
		User user=dao.getUser(uname);
		if(user!=null){
			String em=user.getEmail();
			String mo=user.getMobile();
			if(email.equals(em)&&mobile.equals(mo)){
				HttpSession session=request.getSession(true);
				session.setAttribute("uname", uname);
				request.getRequestDispatcher("updatePassword.jsp").forward(request, response);
			}
		}
	}
	request.setAttribute("status", status);
	request.getRequestDispatcher("forgotpassword.jsp").forward(request, response);
	}

}
