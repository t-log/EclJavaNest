package com.nestjavatraining.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.entity.Customer;
import com.nestjavatraining.service.AccountImpl;

public class BankUtility {
	
	public static void main(String[] args) {
		
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		Account account = null;
		AccountImpl accountImpl = new AccountImpl(); 
		String accountNumber;
		double depositAmount;
		double withdrawAmount;
		Customer customer = null;
		int accountChoice;
		int currentType;
		int savingsType;
		
		ArrayList<Customer> customersList = new ArrayList<>();
		
		while(flag) {
			
			System.out.println("1.Create Account 2.Deposit Amount 3.Withdraw Amount 4.Display Accounts 5.Exit");
			int choice = scanner.nextInt();
			
			switch(choice) {			
			case 1:
				
				  System.out.println("Enter account type: (1.Current Account 2.Savings Account)");
				  accountChoice = scanner.nextInt();
				  if(accountChoice == 1) {
					  System.out.println("Choose from Current Account options: (1.Max Advantage 2.Active Current)");
					  currentType = scanner.nextInt();
					  if(currentType == 1 || currentType == 2) {
						  account = accountImpl.createAccount(accountChoice,currentType);
						  customer = accountImpl.createCustomer(account,customersList);
 
						  customersList.add(customer);
					  }
					  else {
						  System.out.println("Invalid Choice");
					  }
					  
				  }
				  else if(accountChoice == 2) {
					  System.out.println("Choose from Savings Account options: (1.Womens Savings 2.Savings Max)");
					  savingsType = scanner.nextInt();
					  if(savingsType == 1 || savingsType == 2) {
						  account = accountImpl.createAccount(accountChoice,savingsType);
						  customer = accountImpl.createCustomer(account,customersList);
						  customersList.add(customer);	  
					  }
					  else {
						  System.out.println("Invalid Choice");
					  }
				  }
				  else {
					  System.out.println("Invalid Option");
				  }
				              
//				  System.out.println("Customer Name" +" "+"Account Balance");
//				  System.out.println(customer.getCustomerName()+customer.getAccount());
				  System.out.println("Account added successfully");
				  break;
//			case 2: 
//				  //Deposit
//				
//				  System.out.println("Enter account number:");
//				  accountNumber = scanner.next().toUpperCase();
//				  System.out.println("Enter amount to deposit:");
//				  depositAmount = scanner.nextDouble();
//				  accountImpl.depositAmount(accountNumber, depositAmount,accountsList);
//				  
//				  break;
//			case 3: 
//				  //Withdraw
//				  System.out.println("Enter account number:");
//				  accountNumber = scanner.next().toUpperCase();
//				  System.out.println("Enter amount to withdraw:");
//				  withdrawAmount = scanner.nextDouble();
//				  accountImpl.withdrawAmount(accountNumber, withdrawAmount,accountsList);
//				  break;
			case 4: 
				  //Display all accounts
				  System.out.println("SlNo   CustomerName   AccountCode  AccountType             CreateDate   ExpiryDate     Balance  FreeLimit");
				  System.out.println("---------------------------------------------------------------------------------------------------------");
				  accountImpl.displayAllAccount(customersList);
				  break;
			case 5: 
				  flag = false;
				  break;
			default : 
				  System.out.println("Invalid choice");
			}
		}
		
		


	}

}
