package com.canddella.springdemo.service;

import java.util.List;

import com.canddella.springdemo.entity.Product;

public interface ProductService {
	
	public List<Product> displayAllProducts();
	
	public void addProduct(Product product);
	
	public Product getProduct(int productId);
	
	public void deleteProduct(int productId);

}
