package com.hibernate.apps;

import org.hibernate.Session;
import java.util.*;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestHbm {

	public static void main(String[] args) {
		Configuration cfg= new Configuration();
		cfg.configure();
		@SuppressWarnings("deprecation")
		SessionFactory sf=cfg.buildSessionFactory();
		Session hsession=sf.openSession();
		Transaction tx=hsession.beginTransaction();
		Student s=new Student();
		Scanner sc=new Scanner(System.in);
		System.out.println("S_Id");
		int sid=sc.nextInt();
		System.out.println("S_name");
		String sname=sc.next();
		s.setsId(sid);
		System.out.println("S_age");
		int sage=sc.nextInt();
		s.setsName(sname);
		s.setsAge(sage);
		hsession.save(s);
		tx.commit();
		sc.close();
		sf.close();
		
		
		

	}

}
