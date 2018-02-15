package p1;
import p2.Balance;

import java.sql.SQLException;
import java.util.*;

public class WithDraw extends Exception {
	public WithDraw(){}
	public WithDraw(String msg){
		super(msg);
	}
	public void withDraw(int accNo) throws WithDraw, SQLException{
	try{	Balance b1=new Balance(accNo);
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter amt");
	 int amt =sc.nextInt();
		if(amt>b1.balance){
			throw new WithDraw("Insufficient Funds");
		}
		b1.balance=b1.balance-amt;
		b1.disBal(accNo);
		b1.displayBal();
		System.out.println("Amount withdrawn:="+amt);
	} catch(WithDraw w){
		throw w;
	}
	}
}
