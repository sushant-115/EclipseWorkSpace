package com.jerseyclientexample.service;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.jerseyutil.domain.Book;
import com.jerseyutil.domain.ResponseDTO;
import com.jerseyutil.util.JsonUtil;

public class BookServiceClient {

	public ResponseDTO saveBookDetails(Book book) {
	String URL ="http://localhost:8080/Json_Book_Service_Provider/books/registerBook";
//jersey 2.x client code
	System.out.println("bookservice client");
	Client client=ClientBuilder.newClient();
	WebTarget target=client.target("http://localhost:8080/Json_Book_Service_Provider/books/registerBook");
	Builder builder =target.request();
	builder.accept(MediaType.APPLICATION_JSON);
	Response clientResponse=builder.post(Entity.entity(book, MediaType.APPLICATION_JSON));
	String jsonResponse=clientResponse.readEntity(String.class);
	ResponseDTO responseDTO= JsonUtil.convertJsonToJava(jsonResponse, ResponseDTO.class);
	return responseDTO;
	}

}
