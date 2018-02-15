package app1;

import java.io.Serializable;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMaven1 extends Exception {

	TestMaven1(String msg){
		super(msg);
	}
	public static void main(String[] args) throws TestMaven1 {
Configuration cfg =new Configuration();
cfg.configure();
SessionFactory sf=cfg.buildSessionFactory();
Session hsession =sf.openSession();
Transaction tx=hsession.beginTransaction();
Customer c=new Customer();
Scanner sc =new Scanner(System.in);
System.out.println("enter Customer name");
String name=sc.nextLine();
System.out.println("enter 7-digit account no");
Integer c_accno=sc.nextInt();
System.out.println("enter PinNo");
Integer pinNo=sc.nextInt();

try{
	
System.out.println("Re-enter PinNo");
Integer pinNo1=sc.nextInt();
if(!(pinNo.equals(pinNo1))){
	sc.close();
throw new TestMaven1("PinNo not matched\n Try again");	
}
}catch (TestMaven1 t){
	t.printStackTrace();
}
System.out.println("enter Balance");
Double balance=sc.nextDouble();
c.setBalance(balance);
c.setC_accno(c_accno);
c.setC_name(name);
c.setPin_no(pinNo);
Serializable id=hsession.save(c);
tx.commit();
hsession.close();
sc.close();
sf.close();









	}

}
