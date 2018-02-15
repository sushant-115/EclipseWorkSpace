package com.spring.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spring.bean.Address;
import com.spring.bean.Products;

public class TestSpring {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
	Resource resource =new ClassPathResource("com/spring/cfg/myBeans.xml");
	BeanFactory factory =new XmlBeanFactory(resource);
	BeanFactory factory2=new XmlBeanFactory(new ClassPathResource("com/spring/cfg/address.xml"));
	Products products=factory.getBean("products",Products.class);
	System.out.println(products.getpName()+"\t"+products.getpId()+"\t"+products.getPrice());
	Address address=factory2.getBean("address",Address.class);
	System.out.println(address.getCity()+"\t"+address.getState());
		
	}
	
	}


