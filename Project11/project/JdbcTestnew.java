package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTestnew {

	public static void main(String[] args) throws Exception
	{
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection cn= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		 	Statement st =cn.createStatement();
		 	Scanner scan =new Scanner(System.in);
		 	System.out.println("enter username");
		 	String uName= scan.next();
		 	System.out.println("Enter password");
		 	String pwd=scan.next();
		 	String query ="select count(*) from user_register where uname= '"+uName+"'and pwd ='"+pwd+"'";
		 	ResultSet rs = st.executeQuery(query);
		 	rs.next();
		 	int c= rs.getInt(1);
		 	if(c==1){
		 		System.out.println("Welcome to my world");
		 	} else{
		 		System.out.println("invalid username or password");
		 	}
		 	scan.close();
		 	cn.close();


	}

}
