package projectmaven;
import projectmaven.Products;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test1 {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		@SuppressWarnings("deprecation")
		SessionFactory sf =cfg.buildSessionFactory();
		Session hsession = sf.openSession();
		Transaction tx =hsession.beginTransaction();
		Products  p= new Products();
		p.setP_id(101);
		p.setP_name("azsa");
		p.setP_price(100.50f);
		hsession.save(p);
		tx.commit();
		sf.close();
		
	}

}
