package app2;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHbm3 {

	public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure();
	SessionFactory sf=cfg.buildSessionFactory();
	Session hsession =sf.openSession();
	Transaction tx=hsession.beginTransaction();
	Query query=hsession.createQuery("From Employee");
	List<Employee> list=query.getResultList();
	for(Employee e:list){
		System.out.println(e);
	}
	/*Employee e=new Employee();
	e.setE_addr("hyd");
	e.setE_name("aa");
	e.setE_sal(5000.0);
	hsession.save(e);
	*/
	
	tx.commit();
	sf.close();
	
	}

}
