package com.nit.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nit.entity.ProductEntity;
import com.nit.util.HibernateUtil;

public class ProductDaoImpl implements ProductDao {

	public Serializable insertProduct(ProductEntity pEntity) {
		Session hs = HibernateUtil.getSf().openSession();
		Transaction tx = hs.beginTransaction();
		Serializable ser = hs.save(pEntity);
		tx.commit();
		hs.close();
		return ser;
	}

	public List<ProductEntity> retrieveProducts() {
		String hql = "From ProductEntity";
		Session hs = HibernateUtil.getSf().openSession();
		Query query = hs.createQuery(hql);
		List<ProductEntity> pList = query.getResultList();
		hs.close();
		return pList;
	}

	public List<ProductEntity> retrieveProducts(int currPageNo, int pageSize) {
		String hql = "From ProductEntity";
		Session hs = HibernateUtil.getSf().openSession();
		Query query = hs.createQuery(hql);
		query.setFirstResult((currPageNo - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<ProductEntity> pList = query.getResultList();
		hs.close();
		return pList;
	}

	public Long totalRecordsCount() {
		Long size = 0l;
		Session hs = HibernateUtil.getSf().openSession();
		String hql = "select count(*) from ProductEntity";
		Query query = hs.createQuery(hql);
		List<Long> list = query.getResultList();

		if (!list.isEmpty()) {
			size = list.get(0);
		}
		hs.close();
		return size;
	}

}
