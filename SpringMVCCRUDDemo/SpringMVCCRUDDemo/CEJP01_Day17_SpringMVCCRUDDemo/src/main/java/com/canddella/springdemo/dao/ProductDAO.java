package com.canddella.springdemo.dao;

import java.util.List;

import com.canddella.springdemo.entity.Product;

public interface ProductDAO {
	
	public List<Product> displayAllProducts();
	
	public void addProduct(Product product);
	
	public Product getProduct(int productId);
	
	public void deleteProduct(int productId);
}
