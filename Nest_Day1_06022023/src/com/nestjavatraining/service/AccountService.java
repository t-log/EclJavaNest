package com.nestjavatraining.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.nestjavatraining.entity.Account;

public class AccountService {
	
	private static int accountNumberIncrementer = 100;
	
	public static Account createAccount() {
		System.out.println("Enter Name:");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		 
		Account account = new Account("ACC"+Integer.toString(accountNumberIncrementer),name);
		accountNumberIncrementer++;
		return account;
		
	}
	public static void displayAccount(Account acc) {
		System.out.println("Account No: "+acc.getAccountNo());
		System.out.println("Account Name: "+acc.getAccountName());
		System.out.println("Balance: "+acc.getBalance());
	}
	
	public static void depositAmount(String accountNumber,double amountDeposited,ArrayList<Account> accountsList) {
		boolean existFlag = false;
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
		
	}
	public static void withdrawAmount(String accountNumber,double amountWithdrawn,ArrayList<Account> accountsList) {	
		boolean existFlag = false;
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
		
		
	}

}
