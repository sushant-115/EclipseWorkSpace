package testHbmBlob;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestBlob {

	public static void main(String[] args) throws IOException {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session hsession=sf.openSession();
		Transaction tx=hsession.beginTransaction();
		Employee emp=hsession.get(Employee.class,1);
		FileOutputStream fos=new FileOutputStream(emp.getName()+".jpg");
		fos.write(emp.getEmpPhoto());
		fos.flush();
		fos.close();
		/**File file =new File("photo.jpg");
		FileInputStream fis=new FileInputStream(file);
		
		byte[] b=new byte[(int)file.length()];
		
		fis.read(b);
		
		
		emp.setName("bcd");
		emp.setEmpPhoto(b);
		System.out.print("photo"+b);
		Serializable id=hsession.save(emp);**/
		
		tx.commit();
		hsession.close();
		sf.close();
	}

}
