package app;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestMaven {

	public static void main(String[] args) {
Configuration cfg =new Configuration();
cfg.configure();
SessionFactory sf =cfg.buildSessionFactory();
Session hsession =sf.openSession();
Transaction tx=hsession.beginTransaction();
boolean choose=true;
while(choose){
Product p =new Product();
Scanner sc =new Scanner(System.in);


System.out.println("enter P_name");
String p_name=sc.nextLine();
p.setP_name(p_name);
System.out.println("enter price");
double p_price=sc.nextDouble();
p.setP_price(p_price);
Serializable id =hsession.save(p);
System.out.println("Record inserted"+id);
tx.commit();

boolean choose2=true;
while(choose2){
System.out.println("Do you want to continue?(Y/N)");
String option =sc.next();

switch(option){
case "y":
case "Y":choose=true; tx=hsession.beginTransaction();
choose2=false;
break;
case "n":
case "N": choose=false;
choose2=false;
break;
default: System.out.println("Invalid input");
	choose2= true;
}
}
}


sf.close();


	}

}
