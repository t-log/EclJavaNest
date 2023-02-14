package com.nestjavatraining.entity;

public abstract class CurrentAccount extends Account {
	
	
	
	@Override
	public String toString() {
//		return "CurrentAccount [accountBalance=" + accountBalance + "]";
		String forTableFormat = Double.toString(accountBalance);
		return super.toString() +'\t'+ forTableFormat;
	}

	private double accountBalance;

	public CurrentAccount(String accountCode, String accountName, String openingDate, String expiryDate) {
		super(accountCode, accountName, openingDate, expiryDate);
		
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
	

}
