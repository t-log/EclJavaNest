package com.nestjavatraining.utility;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.service.Service;

public class CashWithdrawal implements Service {

	@Override
	public String getAccountService(Account account,double amount) {
		
		if(account.getBalance()>amount) {
			account.setBalance(account.getBalance()-amount);
			return "Cash Withdrawal Successfull!";
		}
		else {
			return "Insufficient Balance!";
		}
	}

}
