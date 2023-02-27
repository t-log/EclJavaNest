package com.nestjavatraining.utility;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.service.Service;

public class AccountApp {

	public static void main(String[] args) {
		
		Service service;
		
		Account account = new Account("ACC100", "Max Savings Account", "Savings Account", 5000);
		
		//load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		double amount = 0;
		int choice;
		
		do{
			
			System.out.println("1. ATM Withdrawal  "
								+ "2. Cash Deposit "
								+ "3. Cash Withdrawal "
								+ "4. Check Deposit " +
								  "5. Exit"); 
			Scanner scanner = new Scanner(System.in); 
			choice = scanner.nextInt();
			
			switch(choice) {
			  case 1:
				  	service = context.getBean("atmWithdrawal",Service.class);
				  	
				  	System.out.println("Enter amount to withdraw");
				  	amount = scanner.nextDouble();
				  	
				  	System.out.println(service.getAccountService(account,amount));
				  	break;
			  case 2:
				  	service = context.getBean("cashDeposit",Service.class);
				  	
				  	System.out.println("Enter amount to deposit");
				  	amount = scanner.nextDouble();
				  	
				  	System.out.println(service.getAccountService(account,amount));
				    break;
			  case 3:
				  	service = context.getBean("cashWithdrawal",Service.class);
				  	
				  	System.out.println("Enter amount to withdraw");
				  	amount = scanner.nextDouble();
				  	
				  	System.out.println(service.getAccountService(account,amount));
			  		break;
			  case 4:
				  	service = context.getBean("checkDeposit",Service.class);
				  	
				  	System.out.println(service.getAccountService(account,amount));
					break;	
			  case 5:
				  	context.close();
				  	break;
			  default:
				  	System.out.println("Invalid Option");
			}
			
		}while(choice>5 ||choice<5);
	}

}
