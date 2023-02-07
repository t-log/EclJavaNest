package com.nestjavatraining.entity;

public class Account {
	
		private String accountNo;
		private String accountName;
		private double balance;
		
		
		public Account(String accountNo, String accountName) {
			
			this.accountNo = accountNo;
			this.accountName = accountName;
		}
		
		public String getAccountNo() {
			return accountNo;
		}
		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}
				
}
