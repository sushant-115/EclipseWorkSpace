package com.jdbc.app;
import java.sql.*;
import java.io.*;

public class JdbcPhoto {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		PreparedStatement ps=cn.prepareStatement("insert into profile values('kirti',?)");
	
		
		File file=new File("D:\\Kriti-Sanon.jpg");
		InputStream fis =new FileInputStream(file);
		ps.setBinaryStream(1, fis);
		int c=ps.executeUpdate();
		if(c==1){
			System.out.println("Record Inserted");
		}
	
		cn.close();
		

	}

}
