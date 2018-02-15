package com.product.service;

import java.io.Serializable;
import java.util.List;

import com.product.entity.ProductDTO;
import com.product.entity.ProductEntity;
import com.product.entity.UserDTO;

public interface ProductService {
	public Serializable signUp(UserDTO user);
public Serializable insertProduct(ProductDTO product);
public List<ProductDTO> retrieveProduct(int start,int max);
public long getResultCount();
public List<ProductDTO> searchProduct(String name);
}
