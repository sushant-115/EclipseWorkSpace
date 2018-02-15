package ProjectJava;
import java.sql.*;
import java.sql.Connection;

public class JdbcTest {

 public static void main(String[] args) throws Exception
 {
	 try{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection cn =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger"); 
	System.out.println("loaded");
	 }
	 catch(Exception e){
		 System.out.println("not loaded"+e);
		 
	 }
 }
}