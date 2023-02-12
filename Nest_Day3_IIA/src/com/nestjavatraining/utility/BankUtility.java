package com.nestjavatraining.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.entity.SavingsAccount;
import com.nestjavatraining.service.SavingsAccountImpl;

public class BankUtility {
	
	

	public static void main(String[] args) {
		
		boolean flag = true;
		Scanner scanner = new Scanner(System.in);
		SavingsAccount savingsAccount = null;
		SavingsAccountImpl savingsAccountImpl = new SavingsAccountImpl(); 
		String accountNumber;
		double depositAmount;
		double withdrawAmount;
		
		
		ArrayList<SavingsAccount> accountsList = new ArrayList<>();
		
		while(flag) {
			
			System.out.println("1.Create Account 2.Deposit Amount 3.Withdraw Amount 4.Display Accounts 5.Exit");
			int choice = scanner.nextInt();
			
			switch(choice) {
			
//			  case 1:
//				  savingsAccount = savingsAccountImpl.createAccount(choice);
//				  System.out.println(savingsAccount);
//				  break;
//			  case 2: 
//				  savingsAccount = savingsAccountImpl.createAccount(choice);
//				  System.out.println(savingsAccount);
//				  break;
//			  default : 
//				  System.out.println("Invalid choice");
			
			case 1:
				
				  System.out.println("Enter account type (1.Womens Savings Account 2.Savings Max Account)");
				  int savingsAccountChoice = scanner.nextInt();
				
				  savingsAccount = savingsAccountImpl.createAccount(savingsAccountChoice);
				  accountsList.add(savingsAccount);
//				  System.out.println(savingsAccount);
				  System.out.println("Account added successfully");
				  break;
			case 2: 
				  //Deposit
				
				  System.out.println("Enter account number:");
				  accountNumber = scanner.next().toUpperCase();
				  System.out.println("Enter amount to deposit:");
				  depositAmount = scanner.nextDouble();
				  savingsAccountImpl.depositAmount(accountNumber, depositAmount,accountsList);
				  
				  break;
			case 3: 
				  //Withdraw
				  System.out.println("Enter account number:");
				  accountNumber = scanner.next().toUpperCase();
				  System.out.println("Enter amount to withdraw:");
				  withdrawAmount = scanner.nextDouble();
				  savingsAccountImpl.withdrawAmount(accountNumber, withdrawAmount,accountsList);
				  break;
			case 4: 
				  //Display all accounts
				  System.out.println("SlNo   AccountCode  AccountType             CreateDate   ExpiryDate     Balance  FreeLimit");
				  System.out.println("------------------------------------------------------------------------------------------");
				  savingsAccountImpl.displayAllAccount(accountsList);
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
