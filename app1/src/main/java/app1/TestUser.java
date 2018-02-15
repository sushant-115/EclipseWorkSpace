package app1;

import jxl.Workbook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUser {

	public static void main(String[] args) {
	
		Configuration cfg =new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session hsession =sf.openSession();
		Transaction tx=hsession.beginTransaction();
		User user=new User();
		user.setuName("sushant");
		user.setPwd("abcdef");
		hsession.save(user);
		tx.commit();
		hsession.close();
		
		sf.close();

	}

}
