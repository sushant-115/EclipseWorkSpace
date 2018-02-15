package com.nit.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private HibernateUtil() {
	}

	private static SessionFactory sf = null;

	public static SessionFactory getSf() {
		if (sf == null) {
			Configuration cfg = new Configuration();
			cfg.configure();
			sf = cfg.buildSessionFactory();
		}
		return sf;
	}
}
