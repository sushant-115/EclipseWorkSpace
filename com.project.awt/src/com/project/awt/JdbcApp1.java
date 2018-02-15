package com.project.awt;
import java.awt.*;
import java.util.*;
import java.sql.*;
import java.awt.event.*;
class EmpWindow extends Frame implements ActionListener
{

	Button b1,b2,b3,b4,b5,b6;
	Label l1,l2,l3;
	TextField t1,t2,t3,t4;
	Connection cn;
	Statement st;
	ResultSet rs;
	String ms;
	EmpWindow() //0-parameter constructor
	{
		b1=new Button("First");
		b2= new Button("Next");
		b3=new Button("Previous");
		b4=new Button("Last");
		b5=new Button("Terminate");
		b6=new Button("Minimize");
		l1=new Label("Empno");
		l2=new Label("EmpName");
		l3=new Label("Salary");
		t1=new TextField(50);
		t2=new TextField(50);
		t3=new TextField(50);
		t4=new TextField(50);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		setLayout(new GridLayout(7,2));
		add(l1);
		add(t1);
		add(l2);
		add(t2);
		add(l3);
		add(t3);
		add(t4);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			st=cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs=st.executeQuery("select empno,ename,sal from emp where sal>2000");
		} catch(Exception k) {
			System.out.println(k);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		String c =e.getActionCommand();
		try{
			if(c.equals("First")){
				rs.first();
				ms=t4.getText();
				System.out.println(ms);
				}
			if(c.equals("Next"))
				rs.next();
			if(c.equals("Last"))
				rs.last();
			if(c.equals("Previous"))
				rs.previous();
			if(c.equals("Terminate")){
				
				dispose();}
			t1.setText(String.valueOf(rs.getInt(1)));
			t2.setText(rs.getString(2));
			t3.setText(String.valueOf(rs.getInt(3)));
		} catch(Exception p) {
			System.out.println(p);
		

		}
		
			
			
			
		}
	
		
	}


public class JdbcApp1 {

	public static void main(String[] args)throws Exception
	{
		EmpWindow w= new EmpWindow();
	
		w.setSize(300, 300);
		w.setVisible(true);
		

	}

}
