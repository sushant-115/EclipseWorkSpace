package com.product.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductUtil {
	private ProductUtil(){}
	private static SessionFactory sf;
	public static SessionFactory gestSF(){
		Configuration cfg=new Configuration();
		cfg.configure();
		if(sf==null)
			sf=cfg.buildSessionFactory();
		
		return sf;
	}

}
