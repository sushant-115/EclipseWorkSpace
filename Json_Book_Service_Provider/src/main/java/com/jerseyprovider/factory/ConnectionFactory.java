package com.jerseyprovider.factory;

import java.sql.*;

public class ConnectionFactory {
static{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public static Connection getConnection() throws SQLException{
Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	
	return con;
	
}
}
