package com.nestjavatraining.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.entity.ActiveCurrentAccount;
import com.nestjavatraining.entity.CurrentAccount;
import com.nestjavatraining.entity.Customer;
import com.nestjavatraining.entity.MaxAdvantageAccount;
import com.nestjavatraining.entity.SavingsAccount;
import com.nestjavatraining.entity.SavingsMaxAccount;
import com.nestjavatraining.entity.WomenSavingsAccount;
import com.nestjavatraining.utility.BankUtility;

public class AccountImpl implements AccountService {
	
	SavingsAccount savingsAccount = null;
	CurrentAccount currentAccount = null;
	
	Scanner scanner = new Scanner(System.in);

	@Override
	public Account createAccount(int accountChoice,int productChoice) {
		
		if(accountChoice == 1) {
			if(productChoice == 1){
				currentAccount = new MaxAdvantageAccount("MAA"+Integer.toString(BankUtility.getMaxAdvantageAccountIncrementer()), "Max Advantage Account", "10.02.2000", "10.02.2030");
				BankUtility.setMaxAdvantageAccountIncrementer(BankUtility.getMaxAdvantageAccountIncrementer()+1);
			}
			else if(productChoice == 2){
		        currentAccount = new ActiveCurrentAccount("ACA"+Integer.toString(BankUtility.getActiveCurrentAccountIncrementer()), "Active Current Account", "10.02.2000", "10.02.2030");
		        BankUtility.setActiveCurrentAccountIncrementer(BankUtility.getActiveCurrentAccountIncrementer()+1);
			}
			return currentAccount;
		}
		else if(accountChoice == 2) {
			if(productChoice == 1){
				savingsAccount = new WomenSavingsAccount("WSA"+Integer.toString(BankUtility.getWomensSavingsAccountIncrementer()), "Women Savings Account","10.02.2000","10.02.2030",0.0,3);
				BankUtility.setWomensSavingsAccountIncrementer(BankUtility.getWomensSavingsAccountIncrementer()+1);
			}
			else if(productChoice == 2){
		        savingsAccount = new SavingsMaxAccount("SMA"+Integer.toString(BankUtility.getSavingsMaxAccountIncrementer()), "Savings Max Account  ","10.02.2010","02.02.2025",0.0);
		        BankUtility.setSavingsMaxAccountIncrementer(BankUtility.getSavingsMaxAccountIncrementer()+1);
			}
			return savingsAccount;
		}
		else {
			return null;
		}
			

	}
	
	@Override
	public Customer createCustomer(Account account,ArrayList<Customer> customersList,boolean isNew,String customerCode) {
		
		String name;
		boolean existFlag = false;
		if(isNew) {
			System.out.println("Enter Name");
			name = scanner.nextLine();
			Customer customer = new Customer("CUS"+Integer.toString(BankUtility.getCustomerNameIncrementer()),name,account);
			
			customersList.add(customer);
			System.out.println("Customer added successfully");
			customer.getAccountslist().add(account);
			
			BankUtility.setCustomerNameIncrementer(BankUtility.getCustomerNameIncrementer()+1);
			return customer;
		}
		else if (isNew == false) {
			for(Customer custo:customersList) {
				if(custo.getCustomerCode().equals(customerCode)) {
					 existFlag = true;
					 custo.getAccountslist().add(account);
					 System.out.println("Account added successfully");
				}	
			}
			if(existFlag == false) {
				System.out.println("Invalid Customer code");
			}
		}
		return null;	
	}

	@Override
	public void depositAmount(String accountNumber,double depositAmount,ArrayList<Customer> customersList) {
		boolean presentFlag = false;
		for(Customer custo:customersList) {
			for(Account account:custo.getAccountslist()) {
				if(account.getAccountCode().equals(accountNumber)) { 
					presentFlag = true;
					if(account instanceof CurrentAccount) {
						((CurrentAccount)account).setAccountBalance(depositAmount);
						System.out.println("Deposit Successfull");
					}
					else if(account instanceof SavingsAccount) {
						((SavingsAccount)account).setAccountBalance(depositAmount);
						System.out.println("Deposit Successfull");
					}	 
				}
			}
					
		}
		if(!presentFlag) {
			System.out.println("Invalid Account");
		}

	}

	@Override
	public void withdrawAmount(String accountNumber,double withdrawAmount,ArrayList<Customer> customersList) {
		boolean presentFlag = false;
		double currentAccountBalance;
		for (Customer custo:customersList){
			for(Account account:custo.getAccountslist()) {
				if (account.getAccountCode().equals(accountNumber)){
		        	 presentFlag = true;
		        	 if(account instanceof CurrentAccount) {
		        		 currentAccountBalance = ((CurrentAccount)account).getAccountBalance();
		        		 if(currentAccountBalance>withdrawAmount) {
		        			 ((CurrentAccount)account).setAccountBalance(currentAccountBalance-withdrawAmount);
			        		 System.out.println("Withdrawal successfull");
			        	 }
			        	 else {
			        		 System.out.println("Insufficient Balance!");
			        	 }
		        	 }
		        	 else if(account instanceof SavingsAccount) {
		        		 currentAccountBalance = ((SavingsAccount)account).getAccountBalance();
		        		 if(currentAccountBalance>withdrawAmount) {
		        			 ((SavingsAccount)account).setAccountBalance(currentAccountBalance-withdrawAmount);
			        		 System.out.println("Withdrawal successfull");
			        	 }
			        	 else {
			        		 System.out.println("Insufficient Balance!");
			        	 }
			        	 
		        	 }       	 
		         }
			}
	         
	         if(!presentFlag) {
	        	 System.out.println("Invalid Account");
	         }
	         
		}

	}
	
	public void displayAllAccount(ArrayList<Customer> customersList) {
		int counter = 1;
		for(Customer custo:customersList) {
				  
				  
				  for(Account account:custo.getAccountslist()) {
					  System.out.print(counter);
					  System.out.print("       ");
					  System.out.print(custo.getCustomerName()+"      ");
					  System.out.print(custo.getCustomerCode()+"      ");
					  System.out.print(account);
					  System.out.println();
					}
				  
			  counter++;
		  }
		
	}

}
