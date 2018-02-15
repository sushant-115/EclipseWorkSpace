package com.hibernate.apps1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestProducts {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("products.cfg.xml");
		@SuppressWarnings("deprecation")
		SessionFactory sf=cfg.buildSessionFactory();
		Session hsession=sf.openSession();
		Transaction tx= hsession.beginTransaction();
		Products p = new Products();
		p.setS_Age(20);
		p.setS_Name("aabb");
		hsession.save(p);
		tx.commit();
		sf.close();
	}
}

