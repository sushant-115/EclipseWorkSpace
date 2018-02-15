package com.jerseyclientexample.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jerseyclientexample.service.BookServiceClient;
import com.jerseyutil.domain.Book;
import com.jerseyutil.domain.ResponseDTO;

public class BookServlet extends HttpServlet {
	private BookServiceClient bookServiceClient;
	public void init(){
		bookServiceClient=new BookServiceClient();
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		System.out.println("in the post");
		Book book =new Book();
		book.setIsbn(req.getParameter("isbn"));
		book.setTitle(req.getParameter("title"));
		book.setAuthor(req.getParameter("author"));
		book.setPrice(Double.parseDouble(req.getParameter("price")));
		ResponseDTO responseDTO=bookServiceClient.saveBookDetails(book);
		req.setAttribute("responseDTO", responseDTO);
		String target="regBook.jsp";
		RequestDispatcher rd=req.getRequestDispatcher(target);
		rd.forward(req, res);
	}

}
