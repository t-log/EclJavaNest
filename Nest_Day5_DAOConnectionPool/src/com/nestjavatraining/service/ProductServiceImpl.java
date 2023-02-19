package com.nestjavatraining.service;

import java.util.List;

import com.nestjavatraining.dao.ProductDao;
import com.nestjavatraining.dao.ProductDaoImpl;
import com.nestjavatraining.entity.Product;


public class ProductServiceImpl implements ProductService {
	
	ProductDao productDao = new ProductDaoImpl(); 

	@Override
	public void deleteProduct(String productCode) {
		
	}

	@Override
	public void saveProduct(Product product) {
		
		productDao.saveProduct(product);
		
	}

	@Override
	public List<Product> listAllProducts() {
		
		return productDao.listAllProducts();
	}

	@Override
	public Product getProduct(String productCode) {
		
		return null;
	}

}
