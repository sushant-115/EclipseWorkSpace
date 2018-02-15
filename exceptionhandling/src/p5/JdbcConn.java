package p5;
import java.sql.*;

public class JdbcConn {
	public static Connection cn, cn2;
	 public static ResultSet rs;
	static{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		cn2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}
public boolean pinCheck(int pinNo,int accNo) throws SQLException{
	PreparedStatement ps=cn.prepareStatement("select pin_no from bank_db where c_accno=?");
	ps.setInt(1, accNo);
	rs =ps.executeQuery();
	if(rs.next()){
		int pin =rs.getInt(1);
		if(pin==pinNo){
			return true;
		}
	}
		
	return false;
		
	}
}
