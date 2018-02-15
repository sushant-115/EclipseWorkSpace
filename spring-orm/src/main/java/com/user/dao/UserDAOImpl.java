package com.user.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.user.pojo.User;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {
@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public int createUser(User user) {
		int count=hibernateTemplate.execute(new HibernateCallback<Integer>(){
			{
		}

			@Override
			public Integer doInHibernate(Session hsession)
					throws HibernateException {
				int count1=0;
				Transaction tx=hsession.beginTransaction();
				Serializable id=hsession.save(user);
				if(id!=null){
					tx.commit();
				return count1+1;}
				return count1;
			}
		});
		
		return count;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list=hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			@Override
			public List<User> doInHibernate(Session hsession)
					throws HibernateException {
			List<User> list1=hsession.createQuery("From com.user.pojo.User").getResultList();
				return list1;
			}
		});
		return list;
	}

	@Override
	public int deleteUser(int userId) {
		int count=hibernateTemplate.execute(new HibernateCallback<Integer>(){
			

			@Override
			public Integer doInHibernate(Session hsession)
					throws HibernateException {
				String hql="delete from com.user.pojo.User as u where u.userId=:userId1";
				Query query=hsession.createQuery(hql);
				query.setParameter("userId1", userId);
				int count1=query.executeUpdate();
				return count1;
			}
		});
		return count;
	}

}
