package testHbmClob;

import java.io.File;

import java.io.FileWriter;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestClobRd {

	public static void main(String[] args) throws Exception {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf =cfg.buildSessionFactory();
		Session hsession =sf.openSession();
		Transaction tx=hsession.beginTransaction();
		Profile up1 =(Profile)hsession.get(Profile.class, 1);
		File file=new File("my.txt");
		FileWriter fw = new FileWriter(file);
		fw.write(up1.getPhoto());
		
		fw.flush();
		fw.close();
		tx.commit();
		sf.close();

	}

}
