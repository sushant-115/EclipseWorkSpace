package com.messaging.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.messaging.dao.MessagingDAOImpl;
import com.messaging.entity.MessageUser;

/**
 * Servlet implementation class InboxServlet
 */
public class InboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String uname=request.getParameter("uname");
	MessagingDAOImpl dao=new MessagingDAOImpl();
	Date date=new Date();
	String option="msg";
	List<MessageUser> list=dao.getMessage(uname);
	String messageStatus="No messages found";
	if(list.size()>=1){
		request.setAttribute("list",list);
		request.setAttribute("date",date);
		request.setAttribute("option",option);
	}
	else{
		request.setAttribute("messageStatus",messageStatus);
	}
	request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
