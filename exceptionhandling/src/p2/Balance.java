package p2;
import p5.JdbcConn;

import java.sql.*;

public class Balance {
	public Balance(){}
	public Balance(int accNo) throws SQLException{
		ps.setInt(1, accNo);
		rs=ps.executeQuery();
		rs.next();
		balance =rs.getInt(1);

	}
	{
		
		 try {
			ps=JdbcConn.cn.prepareStatement("select balance from bank_db where c_accno=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	PreparedStatement ps,ps1;
	ResultSet rs,rs1;
	public int balance ;
	public void disBal(int accNo) throws SQLException {
		ps1=JdbcConn.cn.prepareStatement("update bank_db set balance= ? where c_accno=?");
		ps1.setInt(1, balance);	
		ps1.setInt(2, accNo);
		rs1=ps1.executeQuery();
		
		}
	public void displayBal(){
		System.out.println("Amount Remaining:="+balance);
	}
	
	}
	


