package com.jdbc.app;

import java.sql.*;
import java.sql.DriverManager;

public class JdbcPrepared {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	PreparedStatement ps =cn.prepareStatement("select empno,ename,sal from emp");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		System.out.println(rs.getString(2)+" "+rs.getInt(1)+" "+rs.getInt(3));
	}

	}

}
