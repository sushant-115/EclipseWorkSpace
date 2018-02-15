package com.product.dao;

import java.io.Serializable;
import java.util.List;

import com.product.entity.ProductDTO;
import com.product.entity.ProductEntity;
import com.product.entity.UserDTO;

public interface ProductDAO {
	public Serializable signUp(UserDTO user);
public Serializable insertProduct(ProductDTO product);
public List<ProductEntity> retrieveProduct(int start,int max);
public long getRecordCount();
public List<ProductEntity> searchProduct(String name);
}
