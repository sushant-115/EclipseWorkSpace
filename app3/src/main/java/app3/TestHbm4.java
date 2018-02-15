package app3;

import java.io.FileOutputStream;
import java.io.FileWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHbm4 {

	public static void main(String[] args)throws Exception {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf =cfg.buildSessionFactory();
		Session hsession =sf.openSession();
		Transaction tx=hsession.beginTransaction();
		UserProfile up1 =(UserProfile)hsession.get(UserProfile.class, 1);
		FileOutputStream fos =new FileOutputStream("ganesh1.jpg");
		FileWriter fw = new FileWriter("my.docx");
		fw.write(up1.getU_resume());
		fos.write(up1.getuImage());
		fos.flush();
		fos.close();
		fw.flush();
		fw.close();
		
		tx.commit();
		hsession.close();
		sf.close();
	}

}
