package com.sushant.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SmartQuizServlet extends GenericServlet{

	
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
	String email=	req.getParameter("username");
	res.setContentType("text/html");
	String password=	req.getParameter("password");
		System.out.println(email+""+password);
		res.getWriter().println("<html><body><h2>Successful</h2></body></html>");
	}
	

}
