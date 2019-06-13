package com.standardchartered.crm.models;

import java.util.ArrayList;

public class Customer {

	private int id;
	private String firstName;
	private String lastName;
	private String icNumber;
	private String passportNumber;
	//private Account account;
	private ArrayList<Account> accounts = new ArrayList<Account>();
	

	public Customer(int id, String firstName, String lastName) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		if (id < 0) {

		} else {
			this.id = id;
		}
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getIcNumber() {
		return icNumber;
	}



	public void setIcNumber(String icNumber) {
		this.icNumber = icNumber;
	}



	public String getPassportNumber() {
		return passportNumber;
	}



	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}




	/*
	 * public void doDisplay() { System.out.println("Customer Id: " + this.id);
	 * System.out.println("First Name: " + this.firstName);
	 * System.out.println("Last Name: " + this.lastName);
	 * System.out.println("IC Number: " + this.icNumber);
	 * System.out.println("Passport Number: " + this.passportNumber);
	 * 
	 * }
	 */

	public ArrayList<Account> getAccount() {
		return this.accounts;
	}



	public void setAccount(Account account) {
		this.accounts.add(account);
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Customer) {
			Customer customer = (Customer)obj;
			if (this.id == customer.id && this.firstName == customer.firstName 
					&& this.lastName == customer.lastName) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}



	@Override
	public String toString() {
		String result = "Customer Id: " + this.id + "\n";
		result += "First Name: " + this.firstName + "\n";
		result += "Last Name: " + this.lastName + "\n";
		result += "IC Number: " + this.icNumber + "\n";
		result += "Passport Number: " + this.passportNumber + "\n";
		
		int counter = 0;
		for (Account account : this.getAccount()) {
			counter++;
			result += "--- Account Details " + counter + "/" + this.getAccount().size() + " [" + account.getClass().getSimpleName() + "] --- \n";
			result += account + "\n";
		}
		return result;
	}
	


}
