package com.gyan.service;

import com.gyan.bean.Product;
import com.gyan.bean.ProductList;

public interface ProductService {
	public Product getProductByCode(String code);
	public ProductList getAllProduct();
}
