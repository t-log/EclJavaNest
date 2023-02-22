package com.nestjavatraining.objectsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.nestjavatraining.comparator.CustomerAgeComparator;
import com.nestjavatraining.comparator.CustomerNameComparator;

public class TestCustomer {

	public static void main(String[] args) {
		
		
//		List<Customer> customersList = new ArrayList<Customer>();
//		
//		customersList.add(new Customer(23,"Akhil"));
//		customersList.add(new Customer(22,"Jithin"));
//		customersList.add(new Customer(21,"Varun"));
//		customersList.add(new Customer(20,"Amal"));
//		customersList.add(new Customer(25,"Rahul"));
//		
//		boolean flag = true;
//		Scanner scanner = new Scanner(System.in);
//		
//		do {
//			System.out.println("------------Menu--------- \n "
//					+ "1. Sort on Customer Name \n 2. Sort on Customer Age. \n"
//					+ "Enter your choice :");
//			int choice = scanner.nextInt();
//			
//			if(choice == 1) {
//				Collections.sort(customersList, new Comparator<Customer>() {
//					@Override
//					public int compare(Customer c1,Customer c2) {
//						return c1.getName().compareTo(c2.getName());
//					}
//				});
//				
//			}
//			else if(choice ==2) {
//				Collections.sort(customersList,new Comparator<Customer>() {
//					@Override
//					public int compare(Customer c1,Customer c2) {
//						return Integer.compare(c1.getAge(), c2.getAge());
//					}
//				});
//			}
//			
//			for(Customer customer:customersList) {
//				System.out.println(customer);
//			}
//			
//			System.out.println("Do you wish to continue? y/n");
//			if(scanner.next().toUpperCase().equals("N")) {
//				flag = false;
//			}
//		}while(flag);
//	}
		
		Scanner scanner = new Scanner(System.in);
		char ch;
		String sortingParameter = "";
		
		List<Customer> customerList = new ArrayList<Customer>();

		customerList.add(new Customer(36, "Suneesh"));
		customerList.add(new Customer(4, "Keyaan"));
		customerList.add(new Customer(32, "Remi"));
		customerList.add(new Customer(22, "Saranya"));
		customerList.add(new Customer(23, "Arjun"));
		customerList.add(new Customer(19, "Vineeth"));

		System.out.println("");

		System.out.println("Customer List Before Sorting");

		System.out.println("Customer Name" + " " + "Customer Age");

		for (Customer customer : customerList)
		System.out.println(customer.getName() + " " + customer.getAge());

		do{

		System.out.println("");
		System.out.println("1. Sort Based On Name, 2. Sort Based On Age");

		int choice = scanner.nextInt();

		switch(choice){

		case 1 : 
				 Collections.sort(customerList,(Customer c1, Customer c2)->c1.getName().compareTo(c2.getName())); //lambda expression only applicable to functional interfaces
				 sortingParameter = "Customer List After Sorting Based On Name";
				 break;

		case 2 : 
			Collections.sort(customerList,(Customer c1, Customer c2)->c1.getAge()-(c2.getAge()));
//			Collections.sort(customerList,new Comparator<Customer>() {
//
//			@Override
//			public int compare(Customer o1, Customer o2) {
//				return o1.getAge() - o2.getAge();
//			}
//			
//		});
				 sortingParameter = "Customer List After Sorting Based On Age";
				 break;

		}

		System.out.println(sortingParameter);
		System.out.println("Customer Name" + " " + "Customer Age");

		for (Customer customer : customerList)
		System.out.println(customer.getName() + " " + customer.getAge());

		System.out.println("");
		System.out.println("Do you want to continue (y/n)");
		ch = scanner.next().charAt(0);
		}while(ch == 'y');

		}

}
