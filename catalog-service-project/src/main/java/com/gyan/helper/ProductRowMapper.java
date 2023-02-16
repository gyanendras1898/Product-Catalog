package com.gyan.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.gyan.bean.Product;

@Component
public class ProductRowMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		long id = rs.getLong("id");
		String code = rs.getString("code");
		String name = rs.getString("name");
		String description = rs.getString("description");
		double price = rs.getDouble("price");
		return new Product(id, code, name, description, price);
	}

}
