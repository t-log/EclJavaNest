package com.nestjavatraining.utility;

import com.nestjavatraining.service.Service;

public class ATMWithdrawal implements Service {

	@Override
	public String getAccountService() {
		
		return "ATM Withdrawal Service";
	}

}
