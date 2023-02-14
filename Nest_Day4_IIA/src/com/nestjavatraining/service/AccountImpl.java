package com.nestjavatraining.service;

import java.util.ArrayList;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.entity.ActiveCurrentAccount;
import com.nestjavatraining.entity.CurrentAccount;
import com.nestjavatraining.entity.Customer;
import com.nestjavatraining.entity.MaxAdvantageAccount;
import com.nestjavatraining.entity.SavingsAccount;
import com.nestjavatraining.entity.SavingsMaxAccount;
import com.nestjavatraining.entity.WomenSavingsAccount;

public class AccountImpl implements AccountService {
	
	private static int womensSavingsAccountIncrementer = 100;
	private static int savingsMaxAccountIncrementer = 100;
	private static int maxAdvantageAccountIncrementer = 100;
	private static int activeCurrentAccountIncrementer = 100;
	private static int customerNameIncrementer = 100;
	
	SavingsAccount savingsAccount = null;
	CurrentAccount currentAccount = null;

	@Override
	public Account createAccount(int accountChoice,int productChoice) {
		
		if(accountChoice == 1) {
			if(productChoice == 1){
				currentAccount = new MaxAdvantageAccount("MAA"+Integer.toString(maxAdvantageAccountIncrementer), "Max Advantage Account", "10.02.2000", "10.02.2030");
				maxAdvantageAccountIncrementer++;
			}
			else if(productChoice == 2){
		        currentAccount = new ActiveCurrentAccount("ACA"+Integer.toString(activeCurrentAccountIncrementer), "Active Current Account", "10.02.2000", "10.02.2030");
		        activeCurrentAccountIncrementer++;
			}
			return currentAccount;
		}
		else if(accountChoice == 2) {
			if(productChoice == 1){
				savingsAccount = new WomenSavingsAccount("WSA"+Integer.toString(womensSavingsAccountIncrementer), "Women Savings Account","10.02.2000","10.02.2030",0.0,3);
				womensSavingsAccountIncrementer++;
			}
			else if(productChoice == 2){
		        savingsAccount = new SavingsMaxAccount("SMA"+Integer.toString(savingsMaxAccountIncrementer), "Savings Max Account  ","10.02.2010","02.02.2025",0.0);
		        savingsMaxAccountIncrementer++;
			}
			return savingsAccount;
		}
		else {
			return null;
		}
			

	}
	
	@Override
	public Customer createCustomer(Account account,ArrayList<Customer> customersList) {
		boolean presentFlag = false;
		for(Customer custo:customersList) {
			if(custo.getAccount().equals(account)) {
				presentFlag = true;
				custo.getAccountslist().add(account);
			}		
		}
		if(!presentFlag) {
			Customer customer = new Customer("CUS"+Integer.toString(customerNameIncrementer),"Sample",account);
			customer.getAccountslist().add(account);
			customerNameIncrementer++;
			return customer;
		}
		return null;	
	}

	@Override
	public void depositAmount(String accountNumber,double depositAmount,ArrayList<Customer> customersList) {
		boolean presentFlag = false;
		for(Customer custo:customersList) {
			if(custo.getAccount().getAccountCode().equals(accountNumber)) {
				presentFlag = true;
				if(custo.getAccount() instanceof CurrentAccount) {
					((CurrentAccount)custo.getAccount()).setAccountBalance(depositAmount);
					System.out.println("Deposit Successfull");
				}
				else if(custo.getAccount() instanceof SavingsAccount) {
					((SavingsAccount)custo.getAccount()).setAccountBalance(depositAmount);
					System.out.println("Deposit Successfull");
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
	         if (custo.getAccount().getAccountCode().equals(accountNumber)){
	        	 presentFlag = true;
	        	 if(custo.getAccount() instanceof CurrentAccount) {
	        		 currentAccountBalance = ((CurrentAccount)custo.getAccount()).getAccountBalance();
	        		 if(currentAccountBalance>withdrawAmount) {
	        			 ((CurrentAccount)custo.getAccount()).setAccountBalance(currentAccountBalance-withdrawAmount);
		        		 System.out.println("Withdrawal successfull");
		        	 }
		        	 else {
		        		 System.out.println("Insufficient Balance!");
		        	 }
	        	 }
	        	 else if(custo.getAccount() instanceof SavingsAccount) {
	        		 currentAccountBalance = ((SavingsAccount)custo.getAccount()).getAccountBalance();
	        		 if(custo.getAccount() instanceof CurrentAccount) {
		        		 currentAccountBalance = ((CurrentAccount)custo.getAccount()).getAccountBalance();
		        		 if(currentAccountBalance>withdrawAmount) {
		        			 ((SavingsAccount)custo.getAccount()).setAccountBalance(currentAccountBalance-withdrawAmount);
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
//			  for(Account acc:custo.getAccountslist()) {
				  System.out.print(counter);
				  System.out.print("       ");
				  System.out.println(custo);
//				  System.out.print("        ");
//				  System.out.println(acc);
//			  }
			  counter++;
		  }
	}

	
	
	

}
