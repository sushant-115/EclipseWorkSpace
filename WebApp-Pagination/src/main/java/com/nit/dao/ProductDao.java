package com.nit.dao;

import java.io.Serializable;
import java.util.List;

import com.nit.entity.ProductEntity;

public interface ProductDao {

	public Serializable insertProduct(ProductEntity pEntity);

	public List<ProductEntity> retrieveProducts();

	public List<ProductEntity> retrieveProducts(int start, int end);

	public Long totalRecordsCount();
}
