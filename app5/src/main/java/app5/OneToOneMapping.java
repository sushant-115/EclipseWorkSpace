package app5;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneMapping {

	public static void main(String[] args) throws ParseException {
	SimpleDateFormat sdf =new SimpleDateFormat("dd-MMM-yyyy");
		Configuration cfg=new Configuration();
	cfg.configure();
	SessionFactory sf=cfg.buildSessionFactory();
	Session hsession =sf.openSession();
	Transaction tx=hsession.beginTransaction();
	Person person=new Person();
	Passport passport =new Passport();
	person.setPersonName("Sushant");
	person.setPersonDOB(sdf.parse("06-mar-1995"));
	person.setPassport(passport);
	passport.setPassportId("AAXB15476");
	passport.setIssuedDate(new Date());
	passport.setExpiryDate(sdf.parse("23-sep-2027"));
	passport.setPerson(person);
	Serializable id=hsession.save(person);
	System.out.println("Record inserted"+id);
	
	
	tx.commit();
	sf.close();
	}

}
