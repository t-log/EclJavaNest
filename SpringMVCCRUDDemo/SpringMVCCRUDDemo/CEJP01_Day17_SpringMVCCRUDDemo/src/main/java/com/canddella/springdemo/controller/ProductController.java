package com.canddella.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.canddella.springdemo.entity.Customer;
import com.canddella.springdemo.entity.Product;
import com.canddella.springdemo.service.ProductService;


@Controller
@RequestMapping("/product")
public class ProductController {
	
		// dependency injection
		@Autowired
		private ProductService productService;
		
		@GetMapping("/list")
		public String displayProducts(Model theModel) {
			
			// get products from the service
			List products = (List) productService.displayAllProducts();
					
			// add the customers to the model
			theModel.addAttribute("products", products);
			
			return "list-products";
		}
		
		@GetMapping("/showFormForAdd")
		public String showFormForAdd(Model theModel) {
			
			// create model attribute to bind form data
			Product product = new Product();
			
			theModel.addAttribute("product", product);
			
			return "product-form";
		}
		
		@PostMapping("/saveProduct")
		public String saveProduct(@ModelAttribute("product") Product product) {
			
			// save the product using our service
			productService.addProduct(product);	
			
			return "redirect:/product/list";
		}
		
		@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("productId") int productId,
										Model theModel) {
			
			// get the product from our service
			Product product = productService.getProduct(productId);	
			
			// set product as a model attribute to pre-populate the form
			theModel.addAttribute("product", product);
			
			// send over to our form		
			return "product-form";
		}
		
		@GetMapping("/delete")
		public String deleteCustomer(@RequestParam("productId") int productId) {
			
			// delete the product
		    productService.deleteProduct(productId);
			
			return "redirect:/product/list";
		}
}
