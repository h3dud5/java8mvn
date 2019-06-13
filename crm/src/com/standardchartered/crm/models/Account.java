package com.standardchartered.crm.models;

public class Account {

	private String accountNumber;
	private String branchName;
	
	public Account(String accountNumber, String branchName) {
		this.setAccountNumber(accountNumber);
		this.setBranchName(branchName);
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	@Override
	public String toString() {
		String result = "Account Number: " + this.accountNumber +"\n";
		result += "Branch Name: " + this.branchName + "\n";
		
		return result;
	}
	
}
