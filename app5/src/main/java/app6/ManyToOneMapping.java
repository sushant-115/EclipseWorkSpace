package app6;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToOneMapping {

	public static void main(String[] args) {
Configuration cfg=new Configuration();
cfg.configure("onetomany.cfg.xml");
SessionFactory sf =cfg.buildSessionFactory();
Session hsession =sf.openSession();
Transaction tx=hsession.beginTransaction();
Product p=new Product();
p.setpName("laptop");
p.setpPrice(50000.00);
Store store =new Store();
store.setStoreName("flipkart");
store.setStoreAddr("flipkart.com");
Store store2 =new Store();
store2.setStoreName("amazon");
store2.setStoreAddr("amazon.com");
Store store3 =new Store();
store3.setStoreName("alibaba");
store3.setStoreAddr("alibaba.com");
Set<Store> stores=new HashSet();
stores.add(store);
stores.add(store2);
stores.add(store3);
p.setStore(stores);
hsession.save(p);
System.out.println("Record Inserted");
tx.commit();
hsession.close();
sf.close();
	}

}
