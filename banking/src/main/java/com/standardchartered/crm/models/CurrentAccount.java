package com.standardchartered.crm.models;

public class CurrentAccount extends Account {
	
	private String checkbookNumber;
	
	public CurrentAccount(int id, String accountNumber, String branchName, String checkbookNumber) {
		super(id, accountNumber, branchName);
		setCheckbookNumber(checkbookNumber);
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
		result += "Checkbook Number: " + this.checkbookNumber + "\n";
		
		return result;
		
	}


}
