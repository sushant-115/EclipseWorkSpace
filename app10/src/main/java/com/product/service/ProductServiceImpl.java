package com.product.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.product.dao.ProdcutDAOimpl;
import com.product.dao.ProductDAO;
import com.product.entity.ProductDTO;
import com.product.entity.ProductEntity;
import com.product.entity.UserDTO;

public class ProductServiceImpl implements ProductService  {
	ProductDAO dao=new ProdcutDAOimpl();
	@Override
	public Serializable insertProduct(ProductDTO product) {
		
			
		
		Serializable id=dao.insertProduct(product);
		
		
		return id;
	}

	@Override
	public List<ProductDTO> retrieveProduct(int start, int max) {
		List<ProductEntity> pList=dao.retrieveProduct(start, max);
		List<ProductDTO> pDto=new ArrayList<ProductDTO>();
		
		for(ProductEntity pe:pList){
			ProductDTO pd=new ProductDTO();
			pd.setPid(pe.getPid());
			pd.setpName(pe.getpName());
			
			pd.setpPrice(pe.getpPrice());
			pd.setQuan(pe.getQuan());
			pd.setPhoto(pe.getPhoto());
			pDto.add(pd);
			
		}
		return pDto;
	}

	@Override
	public long getResultCount() {
	long size=dao.getRecordCount();
		return size;
	}

	@Override
	public List<ProductDTO> searchProduct(String name) {
		List<ProductEntity> p=dao.searchProduct(name);
		List<ProductDTO> plist=new ArrayList<ProductDTO>();
		for(ProductEntity pe:p){
			ProductDTO pd=new ProductDTO();
			pd.setPid(pe.getPid());
			pd.setpName(pe.getpName());
			pd.setpPrice(pe.getpPrice());
			pd.setQuan(pe.getQuan());
			pd.setPhoto(pe.getPhoto());
			plist.add(pd);
		}
		return plist;
	}

	@Override
	public Serializable signUp(UserDTO user) {
		Serializable id=0;
		if(null!=user)
			id=dao.signUp(user);
		return id;
	}

}
