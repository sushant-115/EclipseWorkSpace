package p4;

import java.sql.*;

import p5.JdbcConn;

public class Transaction {
	public Transaction(){}
	public Transaction(int accNo) throws SQLException{
		ps.setInt(1,accNo);
		ResultSet rs =ps.executeQuery();
		rs.next();
		count=rs.getInt(1);

	}
	PreparedStatement ps;
	static int count;
	
	{
		try {
			ps=JdbcConn.cn.prepareStatement("select count(*) from bank_db where c_accno=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int accValidate(int accNo){
		if(count==1){
		return 1;
		}
		return 0;
	}

}
