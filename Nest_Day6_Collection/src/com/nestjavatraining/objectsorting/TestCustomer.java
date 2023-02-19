package com.nestjavatraining.objectsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TestCustomer {

	public static void main(String[] args) {
		
		
		List<Customer> customersList = new ArrayList<Customer>();
		
		customersList.add(new Customer(23,"Akhil"));
		customersList.add(new Customer(22,"Jithin"));
		customersList.add(new Customer(21,"Varun"));
		customersList.add(new Customer(20,"Amal"));
		customersList.add(new Customer(25,"Rahul"));
		
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println("------------Menu--------- \n "
					+ "1. Sort on Customer Name \n 2. Sort on Customer Age. \n"
					+ "Enter your choice :");
			int choice = scanner.nextInt();
			
			if(choice == 1) {
				Collections.sort(customersList, new Comparator<Customer>() {
					@Override
					public int compare(Customer c1,Customer c2) {
						return c1.getName().compareTo(c2.getName());
					}
				});
				
			}
			else if(choice ==2) {
				Collections.sort(customersList,new Comparator<Customer>() {
					@Override
					public int compare(Customer c1,Customer c2) {
						return Integer.compare(c1.getAge(), c2.getAge());
					}
				});
			}
			
			for(Customer customer:customersList) {
				System.out.println(customer);
			}
			
			System.out.println("Do you wish to continue? y/n");
			if(scanner.next().toUpperCase().equals("N")) {
				flag = false;
			}
		}while(flag);
	}

}
