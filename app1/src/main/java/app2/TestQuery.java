package app2;




import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import app1.Customer;

public class TestQuery {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure();
		SessionFactory sf=cfg.buildSessionFactory();
		Session hs=sf.openSession();
		String name="vishnu";
		String hql="select c_id,c_name,balance from Customer ";
	 Query query=hs.createQuery(hql);
	 Criteria criteria=hs.createCriteria(Customer.class);
	 criteria.add(Restrictions.ilike("c_name", "vishnu"));
	List<Customer> list= criteria.list();
	for(Customer c:list)
		System.out.println(c.getC_id()+"\t"+c.getC_name()+"\t"+c.getBalance());
		
			}
		}
	
	


