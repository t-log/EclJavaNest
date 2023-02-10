package com.nestjavatraining.service;

import com.nestjavatraining.entity.SavingsAccount;
import com.nestjavatraining.entity.SavingsMaxAccount;
import com.nestjavatraining.entity.WomenSavingsAccount;

public class SavingsAccountImpl implements AccountService {

	@Override
	public SavingsAccount createAccount(int choice) {
		SavingsAccount savingsAccount = null;
		if(choice == 1)
		{
		savingsAccount = new WomenSavingsAccount("WSA001", "Women Savings Account","Feb 10 2023","",1000,3);
		}
		else if(choice == 2)
		{
        savingsAccount = new SavingsMaxAccount("SMA001", "Savings Max Account","Jan 10 2023","",2000);
		}
		return savingsAccount;

	}

	@Override
	public void depositAmount() {
		

	}

	@Override
	public void withdrawAmount() {
		

	}

}
