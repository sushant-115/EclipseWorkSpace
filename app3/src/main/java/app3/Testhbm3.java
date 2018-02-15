package app3;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Testhbm3 {

	public static void main(String[] args) throws Exception {
Configuration cfg=new Configuration();
cfg.configure();
SessionFactory sf =cfg.buildSessionFactory();
Session hsession =sf.openSession();
Transaction tx=hsession.beginTransaction();
String path ="E:\\hyd_pic\\ganesh.jpg";
File f=new File(path);
FileInputStream fis=new FileInputStream(f);
byte[] imageData =new byte[(int)f.length()];
fis.read(imageData);
UserProfile up=new UserProfile();
up.setUname("Ganesh");
up.setuImage(imageData);
File file =new File("D:\\my.txt");
FileReader reader =new FileReader(file);
char[] doc =new char[(int)file.length()];
reader.read(doc);
reader.close();

Serializable id=hsession.save(up);
System.out.println("Record inserted"+id);
tx.commit();
hsession.close();
fis.close();
sf.close();
	}

}
