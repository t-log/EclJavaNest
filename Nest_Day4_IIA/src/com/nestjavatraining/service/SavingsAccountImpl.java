package com.nestjavatraining.service;

import java.util.ArrayList;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.entity.Customer;
import com.nestjavatraining.entity.SavingsAccount;
import com.nestjavatraining.entity.SavingsMaxAccount;
import com.nestjavatraining.entity.WomenSavingsAccount;

public class SavingsAccountImpl implements AccountService {
	
	private static int womensSavingsAccountIncrementer = 100;
	private static int savingsMaxAccountIncrementer = 100;
	SavingsAccount savingsAccount = null;

	@Override
	public SavingsAccount createAccount(int choice) {
		
		if(choice == 1){
		savingsAccount = new WomenSavingsAccount("WSA"+Integer.toString(womensSavingsAccountIncrementer), "Women Savings Account","10.02.2000","10.02.2030",0.0,3);
		womensSavingsAccountIncrementer++;
		}
		else if(choice == 2){
        savingsAccount = new SavingsMaxAccount("SMA"+Integer.toString(savingsMaxAccountIncrementer), "Savings Max Account  ","10.02.2010","02.02.2025",0.0);
        savingsMaxAccountIncrementer++;
		}
		return savingsAccount;

	}

	@Override
	public void depositAmount(String accountNumber,double depositAmount,ArrayList<SavingsAccount> accountsList) {
		boolean existFlag = false;
		for (SavingsAccount account : accountsList){
	         if (account.getAccountCode().equals(accountNumber)){
	        	 account.setAccountBalance(depositAmount);
	        	 existFlag = true;
	        	 System.out.println("Amount deposit successfull");
	         }
		}
		if(!existFlag) {
			System.out.println("Invalid Account");
		}

	}

	@Override
	public void withdrawAmount(String accountNumber,double withdrawAmount,ArrayList<SavingsAccount> accountsList) {
		boolean existFlag = false;
		for (SavingsAccount account : accountsList){
	         if (account.getAccountCode().equals(accountNumber)){
	        	 existFlag = true;
	        	 
	        	 double currentAccountBalance = account.getAccountBalance();
	        	 if(currentAccountBalance>withdrawAmount) {
	        		 account.setAccountBalance(currentAccountBalance-withdrawAmount);
	        		 System.out.println("Withdrawal successfull");
	        	 }
	        	 else {
	        		 System.out.println("Insufficient Balance!");
	        	 }
	        	 
	         }
	         if(!existFlag) {
	        	 System.out.println("Invalid Account");
	         }
	         
		}

	}
	
	public void displayAllAccount(ArrayList<SavingsAccount> accountsList) {
		int counter = 1;
		for (SavingsAccount account : accountsList){
	         System.out.println(Integer.toString(counter) +'\t'+ account);
	         counter++;
		}
	}

	@Override
	public Customer createCustomer(SavingsAccount savingsAccount) {
		
		Customer customer = new Customer("CUS101","Suneesh",savingsAccount);
		return customer;
	}
	
	

}
