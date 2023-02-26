package com.nestjavatraining.utility;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nestjavatraining.service.Service;

public class AccountApp {

	public static void main(String[] args) {
		
		Service service;
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Boolean flag = true;
		
		while(flag){
			
			System.out.println("1. ATM Withdrawal  "
								+ "2. Cash Deposit "
								+ "3. Cash Withdrawal "
								+ "4. Check Deposit " +
								  "5. Exit"); 
			Scanner scanner = new Scanner(System.in); 
			int choice = scanner.nextInt();
			
			switch(choice) {
			  case 1:
				  	service = context.getBean("atmWithdrawal",Service.class);
				  	System.out.println(service.getAccountService());
				  	break;
			  case 2:
				  	service = context.getBean("cashDeposit",Service.class);
				  	System.out.println(service.getAccountService());
				    break;
			  case 3:
				  	service = context.getBean("cashWithdrawal",Service.class);
				  	System.out.println(service.getAccountService());
			  		break;
			  case 4:
				  	service = context.getBean("checkDeposit",Service.class);
				  	System.out.println(service.getAccountService());
					break;	
			  case 5:
				  	flag = false;
				  	break;
			  default:
				  	System.out.println("Invalid Option");
			}
			
		}

	}

}
