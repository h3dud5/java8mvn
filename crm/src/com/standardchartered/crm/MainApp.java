package com.standardchartered.crm;

import java.util.ArrayList;

import com.standardchartered.crm.models.CurrentAccount;
import com.standardchartered.crm.models.Customer;
import com.standardchartered.crm.models.SavingsAccount;
import com.standardchartered.crm.services.CustomerService;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer jegan = new Customer(1, "Thayanithy", "Jegan");
		jegan.setIcNumber("12345678910");
		jegan.setPassportNumber("AB12345");

		Customer john = new Customer(2, "John", "David");
		john.setIcNumber("012345");
		john.setPassportNumber("JD12345");
		
//		jegan.doDisplay();
//		john.doDisplay();
		
		
		/*
		 * Inheritance 
		 */
		
		SavingsAccount savingsAccount = new SavingsAccount("123-456", "Bangsar", 4.5);
		//System.out.println(savingsAccount);
		
		CurrentAccount currentAccount = new CurrentAccount("234-567", "Cheras");
		currentAccount.setCheckbookNumber("00001231546");
		
		jegan.setAccount(savingsAccount);
		jegan.setAccount(currentAccount);
	
//		System.out.println(jegan);
//		System.out.println(john);
		
		CustomerService csv = new CustomerService();
		//csv.getCustomers();
		ArrayList<Customer> customers = csv.getCustomers();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}

}
