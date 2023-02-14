package com.nestjavatraining.entity;

public class Customer {
	
	private String customerCode;
	private String customerName;
	
	private SavingsAccount savingsAccount;

	public Customer(String customerCode, String customerName, SavingsAccount savingsAccount) {
		
		this.customerCode = customerCode;
		this.customerName = customerName;
		this.savingsAccount = savingsAccount;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public SavingsAccount getAccount() {
		return savingsAccount;
	}
    //no setter
	
	
	
	

}
