package com.nestjavatraining.dao;

import java.sql.Connection;
import java.sql.Date;
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
		
		Connection connection = null;
		String insertSQL = "Insert into product(productcode,productname,productdescription,"
							+ "activationdate,expirydate) values(?,?,?,?,?)";
		PreparedStatement prepStmt = null;
		
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection();
			prepStmt = connection.prepareStatement(insertSQL);
			prepStmt.setString(1,product.getProductCode());
			prepStmt.setString(2, product.getProductName());
			prepStmt.setString(3, product.getProductDescription());
			prepStmt.setDate(4, new java.sql.Date(product.getActivationDate().getTime()));
			prepStmt.setDate(5, new java.sql.Date(product.getExpiryDate().getTime()));
			
			System.out.println(prepStmt.executeUpdate()+" records inserted"); 
			
			connection.close();	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

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
		
		Product product = null;
		Connection connection = null; 
		String selectSQL = "Select * from product where productcode = ?"; 
		PreparedStatement prepStmt = null;
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection(); 
			prepStmt = connection.prepareStatement(selectSQL); 
			prepStmt.setString(1, productCode);
			ResultSet resultSet = prepStmt.executeQuery();
			while(resultSet.next()) {
				product = new Product(resultSet.getString(2), resultSet.getString(3),resultSet.getString(4), resultSet.getDate(5), resultSet.getDate(6));
			connection.close();
//			  	System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)+ " " + resultSet.getString(3)
//			  	+ " " + resultSet.getString(4)+ " " + resultSet.getString(5) + " " + resultSet.getString(6)); 
			}
			return product;
			
			}
		catch (SQLException e) {
			e.printStackTrace(); 
		}
		return null;
		
	}

	@Override
	public void deleteProduct(String productCode) {
		Connection connection = null; 
		String deleteSQL = "delete from product where productcode = ?"; 
		PreparedStatement prepStmt = null;
		try {
			DataSource ds = ConnectionPool.getDataSource();
			connection = ds.getConnection(); 
			prepStmt = connection.prepareStatement(deleteSQL); 
			prepStmt.setString(1, productCode);
			System.out.println(prepStmt.executeUpdate()+" records deleted");
			
			connection.close();
			}
		catch (SQLException e) {
			e.printStackTrace(); 
		}
		

	}

}
