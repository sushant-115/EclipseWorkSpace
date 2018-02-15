package com.messaging.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.messaging.dao.MessagingDAOImpl;

public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session;
     public UpdatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String uname=request.getParameter("uname");
if(null!=uname&&!"".equals(uname)){
session=request.getSession(true);	 
session.setAttribute("uname",uname);
	request.getRequestDispatcher("updatePassword.jsp").forward(request, response);
}
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession(true);
		String uname=(String) session.getAttribute("uname");
	String newp=request.getParameter("newp");
	String renewp=request.getParameter("renewp");
	String status="Password was unable to change";
	if(null!=newp&&!"".equals(newp)&&null!=renewp&&!"".equals(renewp)){
		if(newp.equals(renewp)){
			MessagingDAOImpl dao=new MessagingDAOImpl();
			String a=dao.updatePassword(uname, newp);
			if(a!=null){
				status="Password Updated Succesfully";
				request.setAttribute("status", status);
				request.getRequestDispatcher("signin.jsp").forward(request, response);
			}
			
		}
		request.setAttribute("status",status);
		request.getRequestDispatcher("updatePassword.jsp").forward(request, response);
		
	}
	
	}

}
