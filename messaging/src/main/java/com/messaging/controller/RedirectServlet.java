package com.messaging.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.messaging.dao.MessagingDAOImpl;

/**
 * Servlet implementation class RedirectServlet
 */
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
Cookie[] c=request.getCookies();
MessagingDAOImpl dao=new MessagingDAOImpl();
if(null!=c&&c.length!=0){
for(Cookie cookie:c){
	if("un".equals(cookie.getName())){
	String uname=cookie.getValue();
	if(null!=uname){
		boolean k=dao.redirect(uname);
		if(k){
			session=request.getSession(false);
			session.setAttribute("uname",uname);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	}
}
}
request.getRequestDispatcher("signin.jsp").forward(request, response);
}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
