package csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestCsv {

	public static void main(String[] args) throws IOException {
	Configuration cfg=new Configuration();
	cfg.configure();
	SessionFactory sf=cfg.buildSessionFactory();
	Session hsession =sf.openSession();
	Transaction tx=hsession.beginTransaction();
	File file=new File("data.txt");
	FileReader fr=new FileReader(file);
	BufferedReader br=new BufferedReader(fr);
	Employee emp=new Employee();
	String str=br.readLine();
	while(str!=null){
		
		String[] arr=str.split(",");
		emp.setEmpId(Integer.parseInt(arr[0]));
		emp.setEmpName(arr[1]);
		emp.setSal(Double.parseDouble(arr[2]));
		emp.setDept(Integer.parseInt(arr[3]));
		hsession.save(emp);
		tx.commit();
		hsession.close();
		hsession=sf.openSession();
		tx=hsession.beginTransaction();
		str=br.readLine();
	}
	
	hsession.close();
	sf.close();
	}

}
