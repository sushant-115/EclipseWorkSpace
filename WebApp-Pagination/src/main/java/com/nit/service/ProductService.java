package com.nit.service;

import java.io.Serializable;
import java.util.List;

import com.nit.dto.ProductDTO;

public interface ProductService {

	public Serializable insert(ProductDTO pDto);

	public List<ProductDTO> retrieve();

	public List<ProductDTO> retrieve(int start, int end);

	public Long getRecordsCnt();
}
