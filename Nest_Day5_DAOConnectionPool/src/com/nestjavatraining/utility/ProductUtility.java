package com.nestjavatraining.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.nestjavatraining.entity.Product;
import com.nestjavatraining.service.ProductService;
import com.nestjavatraining.service.ProductServiceImpl;

public class ProductUtility {
	
	private static ProductService productService = new ProductServiceImpl();

	public static void main(String[] args) throws ParseException {
		
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
	
	private static void searchProduct() { 
		System.out.println("Enter Prouct Code:");
		Scanner scanner = new Scanner(System.in);
		String productCode = scanner.nextLine();
		System.out.println(productService.getProduct(productCode));
		
	}
	private static void listAllProducts() {
		List<Product> productList = productService.listAllProducts(); 
		System.out.println("Product Code " + " " + "Product Name"+ " " +"Product Description" + " "+ "Activation Date"); 
		for(Product product : productList) 
			System.out.println(product.getProductCode() + " " + product.getProductName()+ " " +product.getProductDescription() + " "+ product.getActivationDate());
			}
	private static void deleteProduct() {
		
		System.out.println("Enter Product Code:");
		Scanner scanner = new Scanner(System.in);
		String productCode = scanner.nextLine();
		productService.deleteProduct(productCode);
		
	}
	private static void saveProduct() throws ParseException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter product code:");
		String productCode = scanner.nextLine();
		System.out.println("Enter product name:");
		String productName = scanner.nextLine();
		System.out.println("Enter product description:");
		String productDescription = scanner.nextLine();
		System.out.println("Enter product activation date:");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String activDate = scanner.nextLine();
		Date activationDate = formatter.parse(activDate);
		System.out.println("Enter expiry date:");
		String expDate = scanner.nextLine();
		Date expiryDate = formatter.parse(expDate);
		Product product = new Product(productCode,productName,productDescription,activationDate,expiryDate);
		
		productService.saveProduct(product);
		
	}

}
