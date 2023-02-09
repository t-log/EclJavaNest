package com.nestjavatraining.dbdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DbDemo {
	
	public static void viewAllEmployee(Connection connection,ResultSet resultSet) throws SQLException {
		Statement statement = connection.createStatement();
		resultSet = statement.executeQuery("select * from employee");
		while(resultSet.next())
		System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2));	
	}
	public static void insertEmployee(String name,PreparedStatement preparedStatement,Connection connection) throws SQLException {
		preparedStatement = connection.prepareStatement("insert into employee(employeename) values(?)");
	  	preparedStatement.setString(1,name);
	  	System.out.println(preparedStatement.executeUpdate()+" records inserted"); 
	}
	public static void searchEmployee(int id,PreparedStatement preparedStatement,ResultSet resultSet,Connection connection) throws SQLException {
		preparedStatement = connection.prepareStatement("select * from employee where employeeid = ?");
	  	preparedStatement.setInt(1,id);
	  	resultSet = preparedStatement.executeQuery();
	  	while(resultSet.next())
	  	System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
	}
	public static void updateEmployee(int id,String name,PreparedStatement preparedStatement,ResultSet resultSet,Connection connection) throws SQLException {
		preparedStatement = connection.prepareStatement("update employee set employeename=? where employeeid =?");
	  	preparedStatement.setString(1,name);
	  	preparedStatement.setInt(2, id);
	  	System.out.println(preparedStatement.executeUpdate()+" records updated"); 
	}
	public static void deleteEmployee(int id,Connection connection,PreparedStatement preparedStatement) throws SQLException {
		preparedStatement = connection.prepareStatement("delete from employee where employeeid =?");
	  	preparedStatement.setInt(1, id);
	  	System.out.println(preparedStatement.executeUpdate()+" records deleted");
	}

	public static void main(String[] args) {
		boolean flag = true;
		String name;
		int id;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{
			String connectionString = "jdbc:mysql://localhost:3306/candella_employee_db?allowPublicKeyRetrieval=true&useSSL=false";
			String userName ="root";
			String password ="";
			Connection connection = DriverManager.getConnection(connectionString,userName,password);
			
			while(flag){
				System.out.println(   "1. View All Employees  "
									+ "2. Insert Employee "
									+ "3. Search Employee "
									+ "4. Update Employee " 
									+ "5. Delete Employee "
									+ "6. Exit"); 
				Scanner scanner = new Scanner(System.in); 
				int choice = scanner.nextInt();
				scanner.nextLine();
				
				switch(choice) {
				  case 1:
					  	viewAllEmployee(connection,resultSet);
					  	break;
				  case 2:	
					  	System.out.println("Enter Name:");
					  	name = scanner.nextLine();
					  	insertEmployee(name,preparedStatement,connection);
					    break;
				  case 3:
					  	System.out.println("Enter Id:");
					  	id = scanner.nextInt();
					  	searchEmployee(id,preparedStatement,resultSet,connection);  
						break;
				  case 4:	
					  	System.out.println("Enter Id :");
					  	id = scanner.nextInt();
					  	scanner.nextLine();
					  	System.out.println("Enter Name to update:");
					  	name = scanner.nextLine();
					  	updateEmployee(id,name,preparedStatement,resultSet,connection);
						break;  	
				  case 5:	
					  	System.out.println("Enter Id :");
					  	id = scanner.nextInt();
					  	deleteEmployee(id,connection,preparedStatement);
					    break;
				  case 6:
					  	flag = false;
					  	connection.close();
						break;		
				  default:
					  	System.out.println("Invalid Option");
				}
				
			}
		
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			}
				
	}

}
