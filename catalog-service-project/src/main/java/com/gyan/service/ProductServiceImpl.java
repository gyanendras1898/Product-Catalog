package com.gyan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyan.bean.Product;
import com.gyan.bean.ProductList;
import com.gyan.persistence.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product getProductByCode(String code) {
		return productDao.getProduct(code);
	}

	@Override
	public ProductList getAllProduct() {
		ProductList productList = productDao.getAllProduct();
		if(productList.getProducts().isEmpty())
			return null;
		return productList;
	}

}
