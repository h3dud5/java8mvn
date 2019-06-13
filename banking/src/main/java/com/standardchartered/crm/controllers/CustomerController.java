package com.standardchartered.crm.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.standardchartered.crm.models.Customer;
import com.standardchartered.crm.services.CustomerService;

public class CustomerController {
	
	private CustomerService customerService;
	
	public CustomerController() {
		this.customerService = new CustomerService();
	}

	public void doListCustomers() {
		ArrayList<Customer> customers = this.customerService.getCustomers();
		for (Customer customer : customers) {
			System.out.println(customer);
		}
	}
	
	public void doViewCustomerById() {
		
		Scanner scanner = new Scanner(System.in);
		String strId = scanner.next();
		
		Customer customer = this.customerService.getCustomerById(Integer.parseInt(strId));
		System.out.println(customer);
	}
	
	public void doNewCustomer() {
		// Getting input from keyboard
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("First Name: ");
		String firstName = scanner.next();
		
		System.out.println("Last Name: ");
		String lastName = scanner.next();
		
		System.out.println("IC Number: ");
		String icNumber = scanner.next();
		
		System.out.println("Passport Number: ");
		String passportNumber = scanner.next();
		
		Customer customer1 = new Customer(0, firstName, lastName);
		customer1.setIcNumber(icNumber);
		customer1.setPassportNumber(passportNumber);
		
		this.customerService.saveCustomer(customer1);
	}
	
	public void doEditCustomer() {
		
		System.out.print("Enter the ID: ");
		Scanner scanner = new Scanner(System.in);
		String strId = scanner.next();
		Customer customer = this.customerService.getCustomerById(Integer.parseInt(strId));
		
		System.out.println("First Name: [" + customer.getFirstName() + "]");
		String firstName = scanner.next();
		customer.setFirstName(firstName);
		
		System.out.println("Last Name: [" + customer.getLastName() + "]");
		String lastName = scanner.next();
		customer.setLastName(lastName);
		
		System.out.println("IC Number: [" + customer.getIcNumber() + "]");
		String icNumber = scanner.next();
		customer.setIcNumber(icNumber);
		
		System.out.println("Passport Number: [" + customer.getPassportNumber() + "]");
		String passportNumber = scanner.next();
		customer.setPassportNumber(passportNumber);
		
		this.customerService.updateCustomer(customer);
		
	}
	
	public void doDeleteCustomer() {
		
		System.out.print("Enter the ID: ");
		Scanner scanner = new Scanner(System.in);
		String strId = scanner.next();
		this.customerService.deleteCustomerById(Integer.parseInt(strId));

	}
}
