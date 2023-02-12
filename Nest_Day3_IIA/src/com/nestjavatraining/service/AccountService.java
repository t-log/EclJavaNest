package com.nestjavatraining.service;

import java.util.ArrayList;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.entity.SavingsAccount;

public interface AccountService {
	
	public Account createAccount(int choice);
	public void depositAmount(String accountNumber,double depositAmount,ArrayList<SavingsAccount> accountsList);
	public void withdrawAmount(String accountNumber,double withdrawAmount,ArrayList<SavingsAccount> accountsList);
}
