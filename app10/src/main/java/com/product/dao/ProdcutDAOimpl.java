package com.product.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.product.entity.ProductDTO;
import com.product.entity.ProductEntity;
import com.product.entity.UserDTO;
import com.product.entity.UserEntity;
import com.product.util.ProductUtil;

public class ProdcutDAOimpl implements ProductDAO{
UserEntity userEntity=new UserEntity();
	@Override
	public Serializable insertProduct(ProductDTO product) {
		
			
		Session hs=ProductUtil.gestSF().openSession();
		Transaction tx=hs.beginTransaction();
		ProductEntity pe=new ProductEntity();
		Serializable ser = null;
		
		pe.setpName(product.getpName());
		pe.setpPrice(product.getpPrice());
		pe.setQuan(product.getQuan());
		pe.setPhoto(product.getPhoto());
		ser=hs.save(pe);
		
		
		tx.commit();
		hs.close();
		return ser;
	}

	@Override
	public List<ProductEntity> retrieveProduct(int start, int max) {
		Session hs=ProductUtil.gestSF().openSession();
		String hql="From ProductEntity";
	
		Query query=hs.createQuery(hql);
		query.setFirstResult((start-1)*max);
		query.setMaxResults(max);
		
		List<ProductEntity> pList=query.getResultList();
		hs.close();
		return  pList;
	}

	@Override
	public long getRecordCount() {
		long size=01;
		Session hs=ProductUtil.gestSF().openSession();
		Query query=hs.createQuery("select count(*) from ProductEntity");
		List<Long> psize=query.getResultList();
		if(!psize.isEmpty())
		size=	psize.get(0);
		return size;
	}

	@Override
	public List<ProductEntity> searchProduct(String name) {
		Session hs=ProductUtil.gestSF().openSession();
		Query query=hs.createQuery("select pid,pName,pPrice,quan ,photo from ProductEntity ");
		Criteria c=hs.createCriteria(ProductEntity.class);
		c.add(Restrictions.ilike("pName",name,MatchMode.ANYWHERE));
		List<ProductEntity> plist=c.list();
		return plist;
	}

	@Override
	public Serializable signUp(UserDTO user) {
Session hs=ProductUtil.gestSF().openSession();
userEntity.setFirstName(user.getFirstName());
userEntity.setLastName(user.getLastName());
userEntity.setPassword(user.getPassword());
userEntity.setMobile(user.getMobile());
Serializable id=hs.save(userEntity);

		return id;
	}

}
