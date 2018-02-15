package p4;
import p1.WithDraw;
import p2.Balance;
import p3.Check;
import p6.Deposit;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MainClass extends Exception  {
	public MainClass(String msg){
		super(msg);
	}

	public static void main(String[] args)throws MainClass, SQLException{
		boolean k =true;
		int accNo = 0;
		int endChoice=1;
	
		Balance b = new Balance();
		WithDraw w=new WithDraw();
		

		Check c=new Check();
		Scanner sc =new Scanner(System.in);
		xyz:
		while(k==true) {
		try{
	

	System.out.println("Enter 7-digit accNo");
	accNo =sc.nextInt();
	
		Transaction tx=new Transaction(accNo);
	int count=tx.accValidate(accNo);
	if(count!=1){
		throw new MainClass("account not exist");
	}
	if(accNo<1000000||accNo>9999999){
		throw new MainClass("Invalid Account no.");
	}
	
	System.out.println("Enter pin");
	int pinNo=sc.nextInt();
	if(pinNo<1000||pinNo>9999){
		throw new MainClass("Invalid pin type \n---Input 4-digit pinNo----");
	
	}
	
	k=c.verify(pinNo,accNo);

		
	

if(Check.count==3){
System.out.println("Pin Blocked\n---try after 24 hours---");	
	break xyz;
}
while(endChoice==1){
if(k==false){
	
try {System.out.println("Enter choice");
System.out.println("1.Deposit\n2.WithDraw");
int choice=sc.nextInt();
switch (choice)
{
case 1:
	
	Deposit d=new Deposit(accNo);	
	
	d.updateBal(accNo);
	
	System.out.println("Do you want yo continue \n1.Yes \n2.No");
	endChoice=sc.nextInt();
	if(endChoice==2)
		System.exit(0);
	if(endChoice==0||endChoice>2)
		throw new MainClass("Invalid Input");
	break;
case 2:
	w.withDraw(accNo);
	System.out.println("Do you want yo continue \n1.Yes\n2.No");
	endChoice=sc.nextInt();
	if(endChoice==2)
		System.exit(0);
	if(endChoice==0||endChoice>2)
		throw new MainClass("--------Invalid Input-----\nTry again");
	break;

	default :
		throw new MainClass("Invalid Choice");
}} catch (WithDraw|MainClass e) {
	
	System.out.println(e.getMessage());
}

	}
	}

}catch(Check |MainClass ob){
			
			System.out.println(Check.count);
			System.out.println(ob.getMessage());
		}
	
		
		}
			
		}
		
	

		
		}
	

	
	


