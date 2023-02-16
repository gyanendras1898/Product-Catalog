package com.gyan.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gyan.bean.Product;
import com.gyan.bean.ProductList;
import com.gyan.helper.ProductRowMapper;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Product addProduct(Product product) {
		String query = "Insert into product values(?,?,?,?,?)";
		int affectedRow = jdbcTemplate.update(query, product.getCode(),product.getName(),product.getDescription(),product.getPrice());
		if(affectedRow>0)
			return lastProductAdded();
		return null;
	}

	@Override
	public Product lastProductAdded() {
		String query = "Select * from product order by id desc limit 1";
		List<Product> products = jdbcTemplate.query(query, new ProductRowMapper());
		if(!products.isEmpty())
			return products.get(0);
		return null;
	}

	@Override
	public Product getProduct(String code) {
		String query = "Select * from product where code =? order by id desc limit 1";
		List<Product> products = jdbcTemplate.query(query, new ProductRowMapper(), code);
		if(!products.isEmpty())
			return products.get(0);
		return null;
	}

	@Override
	public ProductList getAllProduct() {
		String query = "Select * from product";
		ProductList productList = new ProductList(jdbcTemplate.query(query, new ProductRowMapper()));
		return productList;
	}

}
