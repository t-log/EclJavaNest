package com.canddella.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.canddella.springdemo.entity.Customer;
import com.canddella.springdemo.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {
	
	// dependency injection
	@Autowired
	@Qualifier("sessionFactoryTwo")
	private SessionFactory sessionFactoryTwo;

	@Override
	public List<Product> displayAllProducts() {
		// get the current hibernate session
		Session currentSession = sessionFactoryTwo.getCurrentSession();
						
		
		//create mySQL query
		Query<Product> query = currentSession.createNativeQuery("select * from product",Product.class);
				
		// execute query and get result list
		List<Product> products = query.getResultList();
						
		// return the results		
		return products;
	}

	@Override
	public void addProduct(Product product) {
		
		// get current hibernate session
		Session currentSession = sessionFactoryTwo.getCurrentSession();
				
		// save/upate the product
		currentSession.saveOrUpdate(product);

	}

	@Override
	public Product getProduct(int productId) {
		// get the current hibernate session
		Session currentSession = sessionFactoryTwo.getCurrentSession();
				
		// now retrieve/read from database using the primary key
		Product product = currentSession.get(Product.class, productId);
				
		return product;
		

	}

	@Override
	public void deleteProduct(int productId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactoryTwo.getCurrentSession();
		
		//create mySQL query
		Query<Product> query = currentSession.createNativeQuery("delete from product where product_id =:product_id",Product.class);
		query.setParameter("product_id", productId);
		query.executeUpdate();	

	}

}
