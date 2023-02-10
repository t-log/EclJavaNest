package com.nestjavatraining.utility;

import java.util.Scanner;

import com.nestjavatraining.entity.SavingsAccount;
import com.nestjavatraining.service.SavingsAccountImpl;

public class BankUtility {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		SavingsAccount savingsAccount = null;
		SavingsAccountImpl savingsAccountImpl = new SavingsAccountImpl(); 
		System.out.println("1.Women Savings Account 2. Savings Max Account");
		int choice = scanner.nextInt();
		
		switch(choice) {
		
		  case 1:
			  savingsAccount = savingsAccountImpl.createAccount(choice);
			  System.out.println(savingsAccount);
			  break;
		  case 2: 
			  savingsAccount = savingsAccountImpl.createAccount(choice);
			  System.out.println(savingsAccount);
			  break;
		  default : 
			  System.out.println("Invalid choice");
		}

	}

}
