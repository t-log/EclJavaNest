package com.nestjavatraining.entity;

public abstract class SavingsAccount extends Account {
	
	
	@Override
	public String toString() {
		
//		return super.toString()+"\n"+"SavingsAccount [accountBalance=" + accountBalance + "]";
		String forTableFormat = Double.toString(accountBalance);
		return super.toString() +'\t'+ forTableFormat;
	}

	private double accountBalance;

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public SavingsAccount(String accountCode, String accountName, String openingDate, String expiryDate,double accountBalance) {
		super(accountCode, accountName, openingDate, expiryDate);
		this.accountBalance = accountBalance;
	}
	
	
	
}
