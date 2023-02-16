package com.gyan.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	private long id;
	private String code;
	private String name;
	private String description;
	private double price;
	
	public Product(String code, String name, String description, double price) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	
	
}
