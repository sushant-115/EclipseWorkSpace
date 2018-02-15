package com.messaging.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.messaging.dao.MessagingDAO;
import com.messaging.dao.MessagingDAOImpl;
import com.messaging.entity.User;

public class SigninServlet extends HttpServlet {
	
	static HttpSession session;
	 Cookie cookie;
	
	private static final long serialVersionUID = 1L;
       
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logout=request.getParameter("logout");
		
		if(null!=logout){
			
			cookie=new Cookie("un","");
			session.removeAttribute("qno");
			response.addCookie(cookie);
		if(session.isNew()){
				session.invalidate();}
			
			String status="You are logged out successfully";
			request.setAttribute("status", status);
			request.getRequestDispatcher("signin.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String un=request.getParameter("un");
	String captcha=request.getParameter("captcha");
	 session=request.getSession(true);
	String status="Invalid username or password";
	
	String password=request.getParameter("password");
	String captchaKey=(String) session.getAttribute("CAPTCHA_KEY");
	if("r".equals(request.getParameter("rm")))
	{
		cookie=new Cookie("un", un);
		response.addCookie(cookie);
	}
	if(!captcha.equals(captchaKey)){
		status="Invalid Captcha";
		request.setAttribute("status",status);
		request.getRequestDispatcher("signin.jsp").forward(request, response);
		
	}
	if(un!=null&&!"".equals(un)&&password!=null&&!"".equals(password)){
	MessagingDAOImpl dao=new MessagingDAOImpl();
	List<User> list=dao.login(un, password);
	
	String name=null;
	if(null!=list&&list.size()==1){
	
	for(User u:list){
		name=	u.getUname();
		session.setAttribute("name" ,name);
	}
		
	}
	else{
	request.setAttribute("status",status);
	request.getRequestDispatcher("signin.jsp").forward(request, response);}
	}
	request.getRequestDispatcher("home.jsp").forward(request, response);;
	}

}
