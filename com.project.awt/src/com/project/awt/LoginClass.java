package com.project.awt;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import javax.accessibility.AccessibleContext;

import com.project.awt.EmpWindow;


class LoginWindow extends Frame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	AccessibleContext un,pd;


	
	Button b1,b2,b3,b4;
	TextField t1,t2;
	Label l1,l2;
	int count;
	Connection cn;
	Statement stmt;
	ResultSet rs;
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			stmt=cn.createStatement();
				}catch(Exception k) {
			System.out.println(k);
		}
	}
	
	LoginWindow()
	{
	b1=new Button("Login");
	b2=new Button("SignUp");
	b3=new Button("ForgotPassWord");
	b4=new Button("Terminate");
	l1=new Label("UserName");
	l2=new Label("PassWord");
	t1=new TextField(50);
	t2=new TextField(50);
	b1.addActionListener(this);
	b2.addActionListener(this);
	b3.addActionListener(this);
	b4.addActionListener(this);
	t1.echoCharIsSet();
	t2.echoCharIsSet();
	
	setLayout(new GridLayout(4,2));
	add(l1);
	add(t1);
	add(l2);
	add(t2);
	add(b1);
	add(b2);
	add(b3);
	add(b4);
	
	
	}

	
	
	public void actionPerformed(ActionEvent e){
		String c =e.getActionCommand();
		try{
			un=t1.getAccessibleContext();
			t1.getText();
			pd= t2.getAccessibleContext();
			if(c.equals("Login")){
				

				rs=stmt.executeQuery("select count(*) from user_register where uname='"+un+"' and pwd ='"+pd+"'");
				if(rs.next());{
				count=rs.getInt(1);
				if(count==1)
					dispose();}
					
				
				
			}
		if(c.equals("Terminate")){
			cn.close();
			dispose();
		
		}
		}catch(Exception q){
			System.out.println(q);
		}
			
		}
			
		
		
	}

public class LoginClass {

	public static void main(String[] args)throws Exception
	{
		
		LoginWindow l= new LoginWindow();
		EmpWindow w= new EmpWindow();
		l.setSize(500, 300);
		l.setVisible(true);
		if(l.count==1){
			String un=l.t1.getText();
			String pd=l.t2.getText();
			System.out.println(un);
			System.out.println(pd);
			
			
			w.setSize(500,300);
			w.setVisible(true);
		}
		

	}

}
