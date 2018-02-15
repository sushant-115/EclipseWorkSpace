package testHbmClob;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHbmClob {

	public static void main(String[] args) throws Exception {
	Configuration cfg = new Configuration();
	cfg.configure();
	SessionFactory sf = cfg.buildSessionFactory();
	Session hsession =sf.openSession();
	Transaction tx =hsession.beginTransaction();
	Profile p=new Profile();
	p.setSno(1);
	p.setName("ABC");
	File file =new File("D:\\my.txt");
	Reader reader =new FileReader(file);
	char[] txt =new char[(int)file.length()];
	reader.read(txt);
	p.setPhoto(txt);
	Serializable id =hsession.save(p);
	System.out.println("Record insert"+id);
	reader.close();
	tx.commit();
	sf.close();
	

	}

}
