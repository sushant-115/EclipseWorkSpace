package com.jerseyprovider.service;

import java.sql.SQLException;



import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.jerseyprovider.factory.DAOFactory;
import com.jerseyutil.domain.Book;
import com.jerseyutil.domain.ResponseDTO;
import com.jerseyutil.util.JsonUtil;
@Path("books")
public class BookResource {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/registerBook")
	@Consumes(MediaType.APPLICATION_JSON)
	public ResponseDTO registerBook(String JsonBook) throws SQLException{
		System.out.println("Server :"+JsonBook);
		ResponseDTO response =new ResponseDTO();
		response.setMessage("Server problem ,Book details could not be recieved");
		if(JsonBook!=null)
		{
			Book book=JsonUtil.convertJsonToJava(JsonBook, Book.class);
			int count=DAOFactory.getBookDAO().registerBook(book);
		if(count>0){
			response.setStatus((byte)1);
			response.setData(book.getIsbn());
			response.setMessage("Books details saved succesfully");
			
		}
		else{
			response.setMessage("Book Details could not be saved ,please try again");
		}
		System.out.println("Server Response :"+response.getMessage());
		}
		
		return response;
		
	}

}
