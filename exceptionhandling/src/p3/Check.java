package p3;
import java.sql.SQLException;

import p5.JdbcConn;

public class Check extends Exception {
	public static int count;
	int chance=2;
	boolean k;
	public Check(){}
	public Check(String msg){
		
		super(msg);
		
	}
	public boolean verify(int pinNo ,int accNo) throws Check, SQLException{
		try{
			JdbcConn jc=new JdbcConn();
			boolean k =jc.pinCheck(pinNo, accNo);
			if(k==true){
				return false;
			} else {
		        throw new Check("incorrect pin\n ----Chance remain="+chance);
			}

			
	} catch (Check c){
		count++;
		chance-=count;
		throw c;
	}
	

}
}
