package com.nestjavatraining.utility;

import java.util.List;
import java.util.Scanner;

import com.nestjavatraining.entity.Product;
import com.nestjavatraining.service.ProductService;
import com.nestjavatraining.service.ProductServiceImpl;

public class ProductUtility {
	
	private static ProductService productService = new ProductServiceImpl();

	public static void main(String[] args) {
		
		char ch; 
		Scanner scanner = new Scanner(System.in); 
		do {
		System.out.println("1.Save Product, 2.Delete Product, 3.List All Products, 4.Search Product"); 
		int choice = scanner.nextInt(); 
		switch (choice) {
			case 1: saveProduct(); 
			break; 
			case 2: deleteProduct(); 
			break; 
			case 3: listAllProducts(); 
			break; 
			case 4: searchProduct(); 
			break; 
			default: System.out.println("Invalid Choice");
			}
		System.out.println("Do you want to continue (y/n)"); 
		ch = scanner.next().charAt(0);
		}while (ch == 'y');
	}
	
	private static void searchProduct() {  }
	private static void listAllProducts() {
		List<Product> productList = productService.listAllProducts(); 
		System.out.println("Product Code " + " " + "Product Name"+ " " +"Product Description" + " "+ "Activation Date"); 
		for(Product product : productList) 
			System.out.println(product.getProductCode() + " " + product.getProductName()+ " " +product.getProductDescription() + " "+ product.getActivationDate());
			}
	private static void deleteProduct() {}
	private static void saveProduct() {}

}
