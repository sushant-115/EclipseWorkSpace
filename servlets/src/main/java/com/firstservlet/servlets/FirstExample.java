package com.firstservlet.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FirstExample extends GenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
	String s1=arg0.getParameter("t1");
	String s2=arg0.getParameter("t2");
	int n1=Integer.parseInt(s1);
	int n2=Integer.parseInt(s2);
	int n3=n1+n2;
		PrintWriter out=	arg1.getWriter();
	out.println("<html>");
	out.println("<body bgcolor=#00ff0a>");
	out.println("<h2>sum is :"+n3+"</h2>");
	out.println("</body></htm>");	
	String s3=arg0.getParameter("t3");
	String s4=arg0.getParameter("t4");
	int n4=Integer.parseInt(s3);
	int n5=Integer.parseInt(s4);
	int n6=n4-n5;
		
	out.println("<html>");
	out.println("<body bgcolor=#00ff1a>");
	out.println("<h2>subtraction is :"+n6+"</h2>");
	out.println("</body></htm>");	
	}

}
