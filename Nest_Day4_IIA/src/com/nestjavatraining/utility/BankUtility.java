package com.nestjavatraining.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.entity.Customer;
import com.nestjavatraining.service.AccountImpl;

public class BankUtility {
	
	 private static int womensSavingsAccountIncrementer = 100;
	 private static int savingsMaxAccountIncrementer = 100;
	 private static int maxAdvantageAccountIncrementer = 100;
	 private static int activeCurrentAccountIncrementer = 100;
	 private static int customerNameIncrementer = 100;
	  
	
	public static int getWomensSavingsAccountIncrementer() {
		return womensSavingsAccountIncrementer;
	}
	public static void setWomensSavingsAccountIncrementer(int womensSavingsAccountIncrementer) {
		BankUtility.womensSavingsAccountIncrementer = womensSavingsAccountIncrementer;
	}
	public static int getSavingsMaxAccountIncrementer() {
		return savingsMaxAccountIncrementer;
	}
	public static void setSavingsMaxAccountIncrementer(int savingsMaxAccountIncrementer) {
		BankUtility.savingsMaxAccountIncrementer = savingsMaxAccountIncrementer;
	}
	public static int getMaxAdvantageAccountIncrementer() {
		return maxAdvantageAccountIncrementer;
	}
	public static void setMaxAdvantageAccountIncrementer(int maxAdvantageAccountIncrementer) {
		BankUtility.maxAdvantageAccountIncrementer = maxAdvantageAccountIncrementer;
	}
	public static int getActiveCurrentAccountIncrementer() {
		return activeCurrentAccountIncrementer;
	}
	public static void setActiveCurrentAccountIncrementer(int activeCurrentAccountIncrementer) {
		BankUtility.activeCurrentAccountIncrementer = activeCurrentAccountIncrementer;
	}
	public static int getCustomerNameIncrementer() {
		return customerNameIncrementer;
	}
	public static void setCustomerNameIncrementer(int customerNameIncrementer) {
		BankUtility.customerNameIncrementer = customerNameIncrementer;
	}
	
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
		String customerName;
		String isNew;
		String customerCode = null;
		
		ArrayList<Customer> customersList = new ArrayList<>();
		
		
		while(flag) {
			
			System.out.println("1.Create Account 2.Deposit Amount 3.Withdraw Amount 4.Display Accounts 5.Exit");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice) {			
			case 1:
				
				  System.out.println("Are you a New Customer? (Y/N)");
				  isNew = scanner.next();
				  
				  if(isNew.equalsIgnoreCase("N")) {
					  isNew = "false";
					  System.out.println("Enter Customer Code:");
					  customerCode = scanner.next().toUpperCase();
				  }
				  else if(isNew.equalsIgnoreCase("Y")) {
					  isNew = "true";
				  }
				  
				  System.out.println("Enter account type: (1.Current Account 2.Savings Account)");
				  accountChoice = scanner.nextInt();
				  if(accountChoice == 1) {
					  System.out.println("Choose from Current Account options: (1.Max Advantage 2.Active Current)");
					  currentType = scanner.nextInt();
					  if(currentType == 1 || currentType == 2) {
						  account = accountImpl.createAccount(accountChoice,currentType);
						  customer = accountImpl.createCustomer(account,customersList,Boolean.parseBoolean(isNew),customerCode);
						  
//						  customersList.add(customer);
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
						  customer = accountImpl.createCustomer(account,customersList,Boolean.parseBoolean(isNew),customerCode);
//						  customersList.add(customer);	  
					  }
					  else {
						  System.out.println("Invalid Choice");
					  }
				  }
				  else {
					  System.out.println("Invalid Option");
				  }
				              
				 
				  break;
			case 2: 
				  //Deposit
				  System.out.println("Enter account number:");
				  accountNumber = scanner.next().toUpperCase();
				  System.out.println("Enter amount to deposit:");
				  depositAmount = scanner.nextDouble();
				  accountImpl.depositAmount(accountNumber, depositAmount,customersList);
				  break;
			case 3: 
				  //Withdraw
				  System.out.println("Enter account number:");
				  accountNumber = scanner.next().toUpperCase();
				  System.out.println("Enter amount to withdraw:");
				  withdrawAmount = scanner.nextDouble();
				  accountImpl.withdrawAmount(accountNumber, withdrawAmount,customersList);
				  break;
			case 4: 
				  //Display all accounts
				  System.out.println("SlNo   CustomerName   CustomerCode   AccountCode  AccountType             CreateDate   ExpiryDate     Balance  FreeLimit");
				  System.out.println("------------------------------------------------------------------------------------------------------------------------");
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
