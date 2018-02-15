package com.messaging.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MessagingUtil {
	private MessagingUtil(){}
	private static SessionFactory sf;
	public static SessionFactory gestSF(){
		Configuration cfg=new Configuration();
		cfg.configure();
		if(sf==null){
			sf=cfg.buildSessionFactory();
			}
		return sf;
	}

}
