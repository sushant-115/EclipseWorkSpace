package 
import java.sql.*;

public class JdbcTest3 {

	public static void main(String[] args) throws Exception
	{ 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		Statement st= cn.createStatement();
		ResultSet rs =st.executeQuery("select empno,ename,deptno from emp" );
		boolean b =true;
		while(b=true){
		b=rs.next();
			int eno=rs.getInt(1);
			String en=rs.getString(2);
			int dn =rs.getInt(3);
			System.out.printf("\n%d%n%f",eno,en,dn);
			
			
			
		}
		
		


	}

}
