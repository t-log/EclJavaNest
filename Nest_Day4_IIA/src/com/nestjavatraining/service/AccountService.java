package com.nestjavatraining.service;

import java.util.ArrayList;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.entity.Customer;
import com.nestjavatraining.entity.SavingsAccount;

public interface AccountService {
	
	public Account createAccount(int accountChoice,int productChoice);
	public void depositAmount(String accountNumber,double depositAmount,ArrayList<Customer> customersList);
	public void withdrawAmount(String accountNumber,double withdrawAmount,ArrayList<Customer> customersList);
	
	public Customer createCustomer(Account account,ArrayList<Customer> customersList);
}
