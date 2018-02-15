package com.jdbc.app;
import java.util.*;
import java.sql.*;

public class CallableFunction {

	public static void main(String[] args) throws Exception
	{
  Class.forName("oracle.jdbc.driver.OracleDriver");
  Connection cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
  CallableStatement cs =cn.prepareCall("{?=call get_salary(?)}");
  cs.registerOutParameter(1, Types.NUMERIC);
Scanner sc=new Scanner(System.in);
  System.out.println("enter emp");
  int eno=sc.nextInt();
 cs.setInt(2, eno);
 boolean b=cs.execute();
 int sal=cs.getInt(1);
 System.out.println(b+"\n "+sal);
 
 sc.close();
  
	}

}
