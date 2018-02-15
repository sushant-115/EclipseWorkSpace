package com.nit.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.nit.dao.ProductDao;
import com.nit.dao.ProductDaoImpl;
import com.nit.dto.ProductDTO;
import com.nit.entity.ProductEntity;

public class ProductServiceImpl implements ProductService {

	ProductDao dao = new ProductDaoImpl();

	public Serializable insert(ProductDTO pDto) {
		ProductEntity entity = new ProductEntity();
		entity.setProductName(pDto.getPname());
		entity.setProductPrice(pDto.getPrice());
		entity.setProductQuantity(pDto.getQuantity());

		ProductDao dao = new ProductDaoImpl();
		return dao.insertProduct(entity);
	}

	public List<ProductDTO> retrieve() {
		List<ProductDTO> pDtos = new ArrayList<ProductDTO>();
		List<ProductEntity> pEntities = dao.retrieveProducts();

		if (!pEntities.isEmpty()) {
			for (ProductEntity entity : pEntities) {
				ProductDTO dto = new ProductDTO();
				dto.setPid(entity.getProductId());
				dto.setPname(entity.getProductName());
				dto.setPrice(entity.getProductPrice());
				dto.setQuantity(entity.getProductQuantity());
				pDtos.add(dto);
			}
		}
		return pDtos;
	}

	public List<ProductDTO> retrieve(int currPageNo, int pageSize) {
		List<ProductDTO> pDtos = new ArrayList<ProductDTO>();
		List<ProductEntity> pEntities = dao.retrieveProducts(currPageNo,
				pageSize);
		if (!pEntities.isEmpty()) {
			for (ProductEntity entity : pEntities) {
				ProductDTO dto = new ProductDTO();
				dto.setPid(entity.getProductId());
				dto.setPname(entity.getProductName());
				dto.setPrice(entity.getProductPrice());
				dto.setQuantity(entity.getProductQuantity());
				pDtos.add(dto);
			}
		}
		return pDtos;
	}

	public Long getRecordsCnt() {
		return dao.totalRecordsCount();
	}

}
