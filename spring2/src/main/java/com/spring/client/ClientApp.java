package com.spring.client;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.EmployeeService;

public class ClientApp {

	public static void main(String[] args) throws Exception{
	
		@SuppressWarnings("resource")
		ApplicationContext context =new ClassPathXmlApplicationContext("com/spring/cfg/myBeans.xml");
	EmployeeService employeeService=context.getBean("employeeService",EmployeeService.class);
	Scanner sc=new Scanner(System.in);
	System.out.println("---------Enter employee details-------\nEnter Empno");
	int empno=sc.nextInt();
	System.out.println("Emp Name");
	String empname=sc.next();
	System.out.println("Enter salary");
	int sal=sc.nextInt();
	
	
		int c = employeeService.deleteEmployee(empno,empname,sal);
		if(c==1)
		System.out.println("Employee Inserted SuccesFully");
		else
		System.out.println("Employee not inserted --Error occured");
	}

}
