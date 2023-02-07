package com.nestjavatraining.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.service.AccountService;

public class AccountUtility {

	public static void main(String[] args) {
		
		Account acc = null;
		Boolean flag = true;
		
		ArrayList<Account> accountsList = new ArrayList<>();
 
		
		while(flag){
			System.out.println("1. Create Account  "
								+ "2. Display Account "
								+ "3. Deposit Amount "
								+ "4. Withdraw Amount " +
								  "5. Exit"); 
			Scanner scanner = new Scanner(System.in); 
			int choice = scanner.nextInt();
			
			switch(choice) {
			  case 1:
				acc = AccountService.createAccount();
				accountsList.add(acc);
				System.out.println("Account " +acc.getAccountNo()+ 
									" created successfully");
			    break;
			  case 2:
			  	{	
			  		boolean existFlag = false;
			  		System.out.println("Enter account number:");
					String accountNumber = scanner.next().toUpperCase();
				  	
					for (Account account : accountsList){
				         if (account.getAccountNo().equals(accountNumber)){
				        	 AccountService.displayAccount(account);
				        	 existFlag = true;
				        	 break;
				         }
					}
					if(existFlag != true) {
						System.out.println("Invalid account");
					}
					
				    break;
			  	}
			  case 3:
			  	{	
			  		boolean existFlag = false;
			  		System.out.println("Enter account number:");
					String accountNumber = scanner.next().toUpperCase();
					System.out.println("Enter amount to be deposited:");
					double amountDeposited = scanner.nextDouble();
					for (Account account : accountsList){
				         if (account.getAccountNo().equals(accountNumber)){
				        	 double currentBalance = account.getBalance();
				        	 account.setBalance(currentBalance+amountDeposited);
				        	 System.out.println("Amount Deposited");
				        	 existFlag = true;
				        	 break;
				         }
					}
					if(existFlag != true) {
						System.out.println("Invalid account");
					}
					
					break;
			  	}
				
			  case 4:
			  {		
				  	boolean existFlag = false;
			  		System.out.println("Enter account number:");
			  		String accountNumber = scanner.next().toUpperCase();
			  		System.out.println("Enter amount to be Withdrawn:");
					double amountWithdrawn = scanner.nextDouble();
					for (Account account : accountsList){
				         if (account.getAccountNo().equals(accountNumber)){
				        	 existFlag = true;
				        	 double currentBalance = account.getBalance();
				        	 if(currentBalance>amountWithdrawn) {
				        		 account.setBalance(currentBalance-amountWithdrawn);
				        		 System.out.println("Withdrawal Successfull");
				        	 }
				        	 else {
				        		 System.out.println("Insufficient Balance");
				        	 }
				        	 break;
				         }
					}
					if(existFlag != true) {
						System.out.println("Invalid account");
					}
					
					break;
			  	}
				
			  case 5:
				flag = false;
				break;
			  default:
			    System.out.println("Invalid Option");
			}
			
		}
		

	}

}
