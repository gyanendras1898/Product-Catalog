package com.gyan.persistence;

import com.gyan.bean.Product;
import com.gyan.bean.ProductList;

public interface ProductDao {
	
	public Product addProduct(Product product);
	public Product getProduct(String code);
	public ProductList getAllProduct();
	public Product lastProductAdded();

}
