package com.gyan.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gyan.bean.Product;
import com.gyan.bean.ProductList;
import com.gyan.exception.GlobalExceptionHandler;
import com.gyan.exception.ProductNotFoundException;
import com.gyan.service.ProductService;

@RestController
public class ProductResource {

	@Autowired
	private ProductService productService;
	@Autowired
	private GlobalExceptionHandler globalExceptionHandler;
	
	@GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductList> listAllProducts(){
		ProductList products = productService.getAllProduct();
		if(products == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<ProductList>(products,HttpStatus.OK);
	}
	
	@GetMapping(path = "/products/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getProductByCodeResource(@PathVariable("code") String code){
		Product product = productService.getProductByCode(code);
		if(product == null)
			throw new ProductNotFoundException("No Product With Code " + code + " Found");
		return new ResponseEntity<Object>(product,HttpStatus.OK);
	}
	
}
