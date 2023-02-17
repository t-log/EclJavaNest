package com.nestjavatraining.objectsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCustomer {

	public static void main(String[] args) {
		
		
		List<Customer> customersList = new ArrayList<Customer>();
		
		customersList.add(new Customer(23,"Akhil"));
		customersList.add(new Customer(22,"Jithin"));
		customersList.add(new Customer(21,"Varun"));
		customersList.add(new Customer(20,"Amal"));
		customersList.add(new Customer(25,"Rahul"));
		
		System.out.println("Before sort:");
		
		for(Customer customer:customersList) {
			System.out.println(customer.getName());
		}	
		
		Collections.sort(customersList);
		
		System.out.println();
		System.out.println("After sort:");
		
		for(Customer customer:customersList) {
			System.out.println(customer.getName());
		}		

	}

}
