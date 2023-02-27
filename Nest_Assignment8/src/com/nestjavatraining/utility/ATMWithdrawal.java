package com.nestjavatraining.utility;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.service.Service;

public class ATMWithdrawal implements Service {

	@Override
	public String getAccountService(Account account,double amount) {
		
		if(account.getBalance()>(amount+10)){
			account.setBalance(account.getBalance()-(amount+10));
			return "ATM Withdrawal Successfull.Service charge of Rs.10 deducted";
		}
		else {
			return "Insufficient Balance!";
		}
		
	}

}
