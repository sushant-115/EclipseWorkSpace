package com.messaging.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.messaging.entity.MessageUser;
import com.messaging.entity.Questions;
import com.messaging.entity.User;
import com.messaging.entity.UserProfilePhoto;
import com.messaging.util.MessagingUtil;

public class MessagingDAOImpl implements MessagingDAO {

	@Override
	public List login(String userName, String password) {
  Query<User>	 query=MessagingUtil.gestSF().openSession().createQuery("From User where uname=? and password=?");
	query.setParameter(0, userName);
	query.setParameter(1, password);
	List<User> plist=query.list();
	if(plist.size()>=1){
		return plist;
	}
	
		return null;
	}

	@Override
	public int singup(User user) {
	Session hs=MessagingUtil.gestSF().openSession();
	Transaction tx=hs.beginTransaction();
	Serializable id=hs.save(user);
	tx.commit();
	if(id!=null){
		return 1;
		
	}
		return 0;
		
	}

	@Override
	public List<MessageUser> getMessage(String uName) {
	Session hs=MessagingUtil.gestSF().openSession();
	Query<MessageUser> query=hs.createQuery("From MessageUser where uName=?");
	query.setParameter(0, uName);
	List<MessageUser> list=query.list();
	
	
	return list;
	}

	@Override
	public String sendMessage(MessageUser user) {
Session hs=MessagingUtil.gestSF().openSession();
Transaction tx=hs.beginTransaction();
String status="Message not sent!Please try again";
if(user!=null){
	Query query=hs.createQuery("From MessageUser where uName=?");
	query.setParameter(0,user.getuName());
	List list=query.list();
	if(list.size()==0){
		status="User not found";
		return status;
	}
	Serializable id=hs.save(user);
	tx.commit();
	if(id!=null){
		status="Message sent";
		return status;
	}
}
		return status;
	}

	@Override
	public String uploadPhoto(UserProfilePhoto user) {
		Session hs=MessagingUtil.gestSF().openSession();
		Transaction tx=hs.beginTransaction();
		String name=user.getuName();
		byte[] b=retrievePhoto(name);
		if(null!=b&&b.length!=0){
			Query query=hs.createQuery("From UserProfilePhoto where uName=?");
			query.setParameter(0,name);
			UserProfilePhoto up=(UserProfilePhoto) query.list().get(0);
			up.setPhoto(user.getPhoto());
			hs.update(up);
			tx.commit();
			hs.close();
			return "succesfull";
		}
		
		Serializable id=hs.save(user);
		
		tx.commit();
		hs.close();
		if(id!=null){
			return "successfull";
		}
		return null;
	}

	@Override
	public byte[] retrievePhoto(String uName) {
	Query query=MessagingUtil.gestSF().openSession().createQuery("From UserProfilePhoto where uname=?");
	query.setParameter(0,uName);
	List<UserProfilePhoto> list=query.list();
	if(list.size()<1){
		
		return null;
	}
	for(UserProfilePhoto user:list){
		return user.getPhoto();
	}
		
		return null;
	}

	@Override
	public String updatePassword(String uname, String newPassword) {
	Session hs=MessagingUtil.gestSF().openSession();
	Transaction tx=hs.beginTransaction();
	NativeQuery<User> query=hs.createSQLQuery("update Messaging_User set password=? where uname=?");
	query.setParameter(0, newPassword);
	query.setParameter(1,uname);
	int c=query.executeUpdate();
	tx.commit();
	if(c==1)
	{
		
		
		return "password changed";
	}
		return null;
	}

	@Override
	public User getUser(String uname) {
	Query<User> query=MessagingUtil.gestSF().openSession().createQuery("From User where uname=?");
	query.setParameter(0, uname);
	List<User> list=query.getResultList();
	User user=new User();
		for(User u:list){
			
				user.setEmail(u.getEmail());
				user.setMobile(u.getMobile());
				return user;
			
			
		}
		return null;
	}

	@Override
	public boolean redirect(String uname) {
	User user= this.getUser(uname);
	if(null!=user){
		return true;
	}
		
		
		return false;
	}

	@Override
	public List retrieveQuestion(String qType) {
	Session hs=MessagingUtil.gestSF().openSession();
	Query query=hs.createQuery("From Questions where qtype=?");
	query.setParameter(0,qType);
	List list=query.list();

	Collections.shuffle(list);
	 
	int s=list.size();
		
		
		return list;
	}

}
