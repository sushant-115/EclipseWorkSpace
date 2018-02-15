package com.jdbc.app;
import java.sql.*;
import java.util.*;

import oracle.jdbc.internal.OracleTypes;

public class CallableCursor {

	public static void main(String[] args)throws Exception
	{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
CallableStatement cs=cn.prepareCall("{?=call get_salaries(?)}");
cs.registerOutParameter(1, OracleTypes.CURSOR);
Scanner sc=new Scanner (System.in);
System.out.println("enter deptno");
int dno=sc.nextInt();
cs.setInt(2,dno);
cs.execute();
ResultSet rs=(ResultSet)cs.getObject(1);
while(rs.next()){
	System.out.println(rs.getString(2)+" "+rs.getString(1));
	sc.close();
}

	}

}
