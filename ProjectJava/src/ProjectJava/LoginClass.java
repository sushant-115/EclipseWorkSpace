package ProjectJava;
import java.awt.*;

import java.sql.*;
import java.awt.event.*;

import ProjectJava.EmpWindow;


class LoginWindow extends Frame implements ActionListener {
	
	EmpWindow w= new EmpWindow();
	String un,pd;
	Button b1,b2,b3,b4;
	TextField t1,t2;
	Label l1,l2;
	int count;
	Connection cn;
	PreparedStatement ps;
	ResultSet rs;
	
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
	setLayout(new GridLayout(3,2));
	add(l1);
	add(t1);
	add(l2);
	add(t2);
	add(b1);
	add(b2);
	add(b3);
	add(b4);
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sysdba","oracle");
		ps=cn.prepareStatement("select count(*) from user_register where uname='sushant' and pwd ='sushant123'");
			}catch(Exception k) {
		System.out.println(k);
	}
	
	}

	
	
	public void actionPerformed(ActionEvent e){
		String c =e.getActionCommand();
		try{
			if(c.equals("Login")){
				
					un=t1.getText();
					pd=t2.getText();
					ps.setString(1, un);
					ps.setString(2, pd);

				rs=ps.executeQuery();
				rs.next();
				count=rs.getInt(1);
				
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
		l.setSize(300, 300);
		l.setVisible(true);
		

	}

}
