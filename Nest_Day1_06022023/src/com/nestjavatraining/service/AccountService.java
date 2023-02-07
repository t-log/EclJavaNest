package com.nestjavatraining.service;

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

}
