package p3;
import java.util.*;

import functionalinterface.Deposit;
import functionalinterface.Transaction;
import functionalinterface.WithDraw;
import p1.Balance;
import p2.Check;

public class BankClass extends Exception {
	public BankClass(int x,String msg2){
		super(msg2);
	}
	public BankClass(String msg){
		super(msg);
	}

	public static void main(String[] args) throws BankClass, Check{
	Scanner sc =new Scanner(System.in);
	Check c=new Check ();
	Balance b=new Balance();
	boolean k =true;
	int endChoice=1;
	xyz:
	while(k==true)
try{
	System.out.println("Enter pin");
	
	int	pinNo=sc.nextInt();
	
		
	
	if(pinNo<1000||pinNo>9999){
		
		throw new BankClass("---------Invalid PinNo-------\nOnly 4-digit allowed");
	}
	k=c.verify(pinNo);
	
	while(endChoice==1){
			System.out.println("ENTER CHOICE");
	System.out.println("1.withDraw\n2.Deposit\n3.Balance Enquiry");
	int choice =sc.nextInt();
	
	
	switch (choice){
	case 1:
		System.out.println("Enter amount");
		int amt=sc.nextInt();
		
		WithDraw w=(int amount) ->{
			
			if(amount>b.balance){
				throw new BankClass("----:====Insufficient funds===:-----");
			}
			if(amount<0){
				throw new BankClass("-----Invalid Amount------");
			}
			
			b.balance=b.balance-amount;
			b.disBal();
			
			
			
		};
		try {
			w.withDraw(amt);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		break ;
	case 2:
		System.out.println("Enter amount");
		amt=sc.nextInt();
		Deposit d=(int amount)->{
			if(amount<0){
				throw new BankClass("---:====Invalid amount====:----");
			}
			b.balance=b.balance+amount;
			b.disBal();
		};
		try {
			d.deposit(amt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		break;
	case 3:
		b.disBal();
		break;
		default:
			throw new BankClass(choice,"---"+choice+":====Invalid Choice====:------");
			
	}
	
	System.out.println("Do you want to continue\n1.Yes\n2.No");
	endChoice= sc.nextInt();
	}//end of inner while
}//end of try
	catch(BankClass|Check ob){
		System.out.println(ob.getMessage());
	}
	catch(InputMismatchException ime){
		System.out.println("Invalid ..only integer");
		System.exit(0);
	}

	}//end of while

	}


