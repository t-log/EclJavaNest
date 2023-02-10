package com.nestjavatraining.entity;

public class WomenSavingsAccount extends SavingsAccount {
	
	private int freeLimit;


	public WomenSavingsAccount(String accountCode, String accountName, String openingDate, String expiryDate,double accountBalance, int freeLimit) {
		super(accountCode, accountName, openingDate, expiryDate, accountBalance);
		this.freeLimit = freeLimit;
	}

	public int getFreeLimit() {
		return freeLimit;
	}

	public void setFreeLimit(int freeLimit) {
		this.freeLimit = freeLimit;
	}
	
	
}
