package p2;

import p3.BankClass;

public class Check extends Exception{
	public Check(){}
	public Check (String msg){
		super(msg);
	}
	public static int count=0;
	boolean k;
public boolean verify(int pinNo)throws Check{
try{	switch (pinNo){
	case 1111: k=false;
		break;
		default: 
			throw new Check("--------=======Invalid Pin=========--------\n-----======Try again=====-------");
	}
}catch(Check c){
	
	count++;
if(count>=3){
		
		try {
			throw new BankClass("------:====Transaction Blocked====:------");
		} catch (BankClass e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
	}
	System.out.println(count);
	throw c;
}
return k;
}

}
