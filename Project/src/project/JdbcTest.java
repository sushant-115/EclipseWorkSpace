package project;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcTest {



	public static void main(String[] args) 
	{
		Connection cn;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","hr","hr");
		System.out.println("registered");
		}
		catch(Exception e) {
			System.out.println("driver not registered "+e);
		}
		

	}

}
