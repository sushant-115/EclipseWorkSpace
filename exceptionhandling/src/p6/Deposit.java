package p6;
import p2.Balance;
import p5.JdbcConn;

import java.util.*;
import java.sql.*;

public class Deposit {
	
	public Deposit(int accNo) throws SQLException{
		ps1=JdbcConn.cn2.prepareStatement("update bank_db set balance= ? where c_accno=?");
		b5=new Balance(accNo);
		b5.disBal(accNo);
		balance =b5.balance;
		
		
		
		

	}
	Balance b5;
	PreparedStatement ps1;
	ResultSet rs1;
	public int balance ;
	public void updateBal(int accNo) throws SQLException {
		ps1.setInt(2, accNo);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter amount to be deposit");
		int amt= sc.nextInt();
		balance+=amt;
		ps1.setInt(1, balance);	
		
		int count=ps1.executeUpdate();
		System.out.println("Available Amount :="+balance);
		
	
		}
	
}
