package com.standardchartered.crm.models;

public abstract class Account {

	private int id;
	private String accountNumber;
	private String branchName;
	private Customer customer;
	
	public Account(int id, String accountNumber, String branchName) {
		this.setAccountNumber(accountNumber);
		this.setBranchName(branchName);
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public abstract void performAction();
	
	@Override
	public String toString() {
		String result = "Account Number: " + this.accountNumber +"\n";
		result += "Branch Name: " + this.branchName + "\n";
		
		return result;
	}
	
}
