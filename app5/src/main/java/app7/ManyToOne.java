package app7;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOne {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session hsession =sf.openSession();
		Transaction tx=hsession.beginTransaction();
		Student std1=new Student();
		Student std2=new Student();
		Address addr =new Address();
		addr.setCity("hyd");
		addr.setState("tg");
		addr.setCountry("in");
		std1.setsName("sushant");
		std1.setsMobile(99887766);
		std2.setAddr(addr);
		std2.setsName("abcdef");
		std2.setsMobile(987456321);
		std1.setAddr(addr);
		hsession.save(std1);
		hsession.save(std2);
		
		
		
		tx.commit();
		hsession.close();
		sf.close();
	}

}
