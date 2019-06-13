package com.standardchartered.crm.models;

public class SavingsAccount extends Account {

	private double interestRate;

	public SavingsAccount(String accountNumber, String branchName, double interestRate) {
		super(accountNumber, branchName);
		this.setInterestRate(interestRate);
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public String toString() {
		String result = super.toString();
		result += "Interest Rate: " + this.interestRate;
		
		return result;
	}

	@Override
	public void performAction() {
		// TODO Auto-generated method stub
		
	}
	
}
