package com.jdbc.app;
import java.sql.*;
import java.io.*;
import com.jdbc.app.*;

public class JdbcClob {

	public static void main(String[] args) throws Exception
	{
 Class.forName("oracle.jdbc.driver.OracleDriver");
 Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
 PreparedStatement ps=cn.prepareStatement("insert into resume_table values(?,?)");
 ps.setString(1,"Ayan");
 FileReader fr =new FileReader("New Text Document.txt");
 ps.setCharacterStream(2, fr);
 int c =ps.executeUpdate();
 System.out.println(c);
	}

}
