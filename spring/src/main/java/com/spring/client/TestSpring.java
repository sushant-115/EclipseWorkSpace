package com.spring.client;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spring.bean.QuestionBean;

public class TestSpring {

	public static void main(String[] args) {
Resource resource =new ClassPathResource("com/spring/cfg/myBeans.xml");
BeanFactory factory = new XmlBeanFactory(resource);
QuestionBean questionBean =(QuestionBean)factory.getBean("questionBean");
System.out.println("Question:"+questionBean.getQuestion());
Map<String,String> map =questionBean.getAnswers();
Set<String> keys =map.keySet();
int i =5;

Date d=new Date();
for (String key:keys){
	i--;
	
	System.out.println("Posted by:" +map.get(key)+"\tAnswers:"+key +"\tPosted on:"+d);
}

	}

}
