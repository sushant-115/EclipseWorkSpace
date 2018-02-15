package com.jdbc.app;
import java.sql.*;
import java.util.*;

public class JdbcCallable {

	public static void main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	CallableStatement cs=cn.prepareCall("{call sal_update(?,?)}");
	cs.registerOutParameter(2, Types.NUMERIC);
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter emp no");
	int eno=sc.nextInt();
	cs.setInt(1, eno);
    boolean b =cs.execute();
	System.out.println(b);
	int sal=cs.getInt(2);
	System.out.println(sal);
	sc.close();
	

	}

}
