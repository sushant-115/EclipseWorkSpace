package appTestPhoto;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestPhoto {
	public Serializable insert(byte[] b){
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session hsession =sf.openSession();
		Transaction tx=hsession.beginTransaction();
		Product p=new Product();
		p.setPhoto(b);
		Serializable id=hsession.save(p);
		tx.commit();
		hsession.close();
		sf.close();
		return id;
	}

}
