package com.standardchartered.crm;

import com.standardchartered.crm.controllers.CustomerController;

public class MainApp {

	public static void main(String[] args) {
		
		CustomerController customerController = new CustomerController();
		customerController.doListCustomers();
		System.out.println("-------------------------------");
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter the ID: ");
//		String strId = scanner.next();
		
		//mainApp.showCustomerById(Integer.parseInt(strId));
		//System.out.println("-------------------------------");
		//mainApp.doNewCustomer();
		//System.out.println("-------------------------------");
		//mainApp.doListCustomers();
		
		//mainApp.doEditCustomer();
		//customerController.doDeleteCustomer();
		
		//customerController.doListCustomers();
		
		
		
	}

}
