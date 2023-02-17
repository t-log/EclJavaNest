package com.nestjavatraining.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nestjavatraining.connectionpool.ConnectionPool;
import com.nestjavatraining.entity.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public void saveProduct(Product product) {
		

	}

	@Override
	public List<Product> listAllProducts() {
		
		
		List<Product> productList = new ArrayList<Product>(); 
		Connection connection = null; 
		String selectSQL = "Select * from product"; 
		PreparedStatement prepStmt = null;
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection(); 
			prepStmt = connection.prepareStatement(selectSQL); 
			ResultSet resultSet = prepStmt.executeQuery();
			while (resultSet.next()) {
				productList.add(new Product(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getDate(6))); 
			}
			connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace(); 
		}
		return productList;
	}

	@Override
	public Product getProduct(String productCode) {
		
		return null;
	}

	@Override
	public void deleteProduct(String productCode) {
		

	}

}
