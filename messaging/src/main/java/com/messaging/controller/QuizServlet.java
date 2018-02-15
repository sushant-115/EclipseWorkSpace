package com.messaging.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import oracle.sql.CharacterBuffer;

import org.hibernate.engine.jdbc.CharacterStream;
import org.hibernate.engine.jdbc.internal.CharacterStreamImpl;

import com.messaging.dao.MessagingDAOImpl;
import com.messaging.entity.Questions;

/**
 * Servlet implementation class QuizServlet
 */
public class QuizServlet extends HttpServlet {
	Integer count;
	Integer qno;
	List<Questions> list;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String ques=request.getParameter("ques");

String option="radio";
if(null!=ques&&!"".equals(ques)){
	HttpSession session=request.getSession(true);
	MessagingDAOImpl dao=new MessagingDAOImpl();
	Integer qn= (Integer) session.getAttribute("qno");
	Integer qno=0;
	if(null!=qn)
	 qno=qn;
	if(qno==0)
		session.removeAttribute("count");
	list=(List) session.getAttribute("shuffledList");
	if(null==list){
 list=dao.retrieveQuestion(ques);
 session.setAttribute("shuffledList", list);}
 
 Questions question=list.get(qno);
	session.setAttribute("realAnswer", question.getRealAnswer());
	session.setAttribute("qno", qno);
	count= (Integer) session.getAttribute("count") ;
	if(null==count){
	count=0;}
	session.setAttribute("count", count);
	session.setAttribute("ques", ques);
	char[] c=question.getCode();
	String cs=Arrays.toString(c);
	String cse=cs.replace(",", "");
	String csee=cse.replace(" ", "");
	String csef=csee.replace("_", " ");
	String[] arr=csef.split(";");
	
	String[] answers=new String[]{question.getAnswer1(),question.getAnswer2(),question.getAnswer3(),question.getAnswer4()};
	if(null!=arr)
	request.setAttribute("code",arr );
	request.setAttribute("question", question.getQuestion());
	request.setAttribute("answers",answers);
	request.setAttribute("option", option);
	request.getRequestDispatcher("home.jsp").forward(request, response);
}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String qtype=request.getParameter("qtype");
	String ques=request.getParameter("ques");
	String qn=request.getParameter("qno");
	String option="radio";
	Integer qno=0;
	if(null!=qn){
		qno=Integer.parseInt(qn);
		
		
	}
	HttpSession session=request.getSession(true);
	String status="please choose an answer";
	session.removeAttribute("status");
	count=(Integer) session.getAttribute("count");
	if(qtype.equals("radio")){
	String realAnswer=(String) session.getAttribute("realAnswer");	
	String answer=request.getParameter("answer");
	if(null==answer||"".equals(answer)){
	session.setAttribute("status", status);
	request.getRequestDispatcher("home.jsp").forward(request,response);
	}
	if(answer.equals(realAnswer)){
		count++;
		session.setAttribute("count", count);
		
	}
	if(qno==10){
		String score="Your Total score is="+count+"/10";
	request.setAttribute("score", score);
	session.removeAttribute("qno");
	session.removeAttribute("shuffledList");
	request.getRequestDispatcher("home.jsp").forward(request, response);}
	
	MessagingDAOImpl dao=new MessagingDAOImpl();
	list=(List) session.getAttribute("shuffledList");
	if(null==list){
 list=dao.retrieveQuestion(ques);
 session.setAttribute("shuffledList", list);}
	Questions question=list.get(qno);
	session.setAttribute("realAnswer", question.getRealAnswer());
	session.setAttribute("qno", qno);
	if(null==count){
	count=0;}
	
	char[] c=question.getCode();
	String cs=Arrays.toString(c);
	String cse=cs.replace(",", "");
	String csee=cse.replace(" ", "");
	String csef=csee.replace("_", " ");
	String[] arr=csef.split(";");
	String[] answers=new String[]{question.getAnswer1(),question.getAnswer2(),question.getAnswer3(),question.getAnswer4()};
	if(null!=arr)
	request.setAttribute("code",arr );
	request.setAttribute("question", question.getQuestion());
	request.setAttribute("answers",answers);
	request.setAttribute("option", option);
	request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	}

}
