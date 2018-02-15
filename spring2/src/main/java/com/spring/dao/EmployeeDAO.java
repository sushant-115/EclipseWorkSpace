package com.spring.dao;

import java.sql.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;




@Repository
public class EmployeeDAO {
	@Autowired
	private  DataSource dataSource;
	Connection con=null;


public Connection getConnection() throws SQLException{
con =dataSource.getConnection();
	return con;


}

}