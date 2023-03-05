package com.canddella.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canddella.springdemo.dao.ProductDAO;
import com.canddella.springdemo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
		// need to inject product dao
		@Autowired
		private ProductDAO productDAO;

	@Override
	@Transactional("myTransactionManagerTwo")
	public List<Product> displayAllProducts() {
		
		return productDAO.displayAllProducts();
	}

	@Override
	@Transactional("myTransactionManagerTwo")
	public void addProduct(Product product) {
		
		productDAO.addProduct(product);

	}

	@Override
	@Transactional("myTransactionManagerTwo")
	public Product getProduct(int productId) {
		return productDAO.getProduct(productId);
		

	}

	@Override
	@Transactional("myTransactionManagerTwo")
	public void deleteProduct(int productId) {
		
		productDAO.deleteProduct(productId);
	}

}
