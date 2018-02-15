package com.jerseyprovider.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jerseyprovider.factory.ConnectionFactory;
import com.jerseyutil.domain.Book;

public class BookDAo {
	private static final String SQL_REGISTER_BOOK="insert into Book_Details values(?,?,?,?)";
	public int registerBook(Book book) throws SQLException{
		int count =0;
		Connection con =ConnectionFactory.getConnection();
		PreparedStatement ps=con.prepareStatement(SQL_REGISTER_BOOK);
		ps.setString(1, book.getIsbn());
		ps.setString(2, book.getTitle());
		ps.setString(3, book.getAuthor());
		ps.setDouble(4,book.getPrice());
		count=ps.executeUpdate();
		
		return count;
	}

}
