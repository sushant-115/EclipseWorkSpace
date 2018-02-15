package com.jerseyprovider.factory;

import com.jerseyprovider.dao.BookDAo;

public class DAOFactory {
private static BookDAo bookDAO;
static{
	bookDAO=new BookDAo();
}
public static BookDAo getBookDAO(){
	
	return bookDAO;
	
}
}
