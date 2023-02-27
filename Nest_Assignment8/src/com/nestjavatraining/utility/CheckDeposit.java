package com.nestjavatraining.utility;

import com.nestjavatraining.entity.Account;
import com.nestjavatraining.service.Service;

public class CheckDeposit implements Service {

	@Override
	public String getAccountService(Account account,double amount) {
		
		return account.getBalance()+"";
	}

}
