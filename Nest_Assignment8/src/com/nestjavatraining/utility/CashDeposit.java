package com.nestjavatraining.utility;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.service.Service;

public class CashDeposit implements Service {

	@Override
	public String getAccountService(Account account,double amount) {
		
		account.setBalance(account.getBalance()+amount);
		
		return "Deposit Successfull!";
	}

}
