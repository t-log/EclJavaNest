package com.nestjavatraining.utility;

import com.nestjavatraining.service.Service;

public class CashWithdrawal implements Service {

	@Override
	public String getAccountService() {
		
		return "Cash Withdrawal Service";
	}

}
