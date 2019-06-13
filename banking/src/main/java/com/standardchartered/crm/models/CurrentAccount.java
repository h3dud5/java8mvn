package com.standardchartered.crm.models;

public class CurrentAccount extends Account {
	
	private String checkbookNumber;
	
	public CurrentAccount(String accountNumber, String branchName) {
		super(accountNumber, branchName);
		// TODO Auto-generated constructor stub
	}

	public String getCheckbookNumber() {
		return checkbookNumber;
	}

	public void setCheckbookNumber(String checkBookNumber) {
		this.checkbookNumber = checkBookNumber;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		result += "Checkbook Number: " + this.checkbookNumber;
		
		return result;
		
	}

	@Override
	public void performAction() {
		// TODO Auto-generated method stub
		
	}

}
