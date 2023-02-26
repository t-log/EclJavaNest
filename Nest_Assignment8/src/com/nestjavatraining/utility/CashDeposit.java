package com.nestjavatraining.utility;

import com.nestjavatraining.service.Service;

public class CashDeposit implements Service {

	@Override
	public String getAccountService() {
		
		return "Cash Deposit Service";
	}

}
