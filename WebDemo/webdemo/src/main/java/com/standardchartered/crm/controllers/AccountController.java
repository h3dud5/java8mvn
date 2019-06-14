package com.standardchartered.crm.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import com.standardchartered.crm.models.Account;
import com.standardchartered.crm.models.CurrentAccount;
import com.standardchartered.crm.models.Customer;
import com.standardchartered.crm.models.SavingsAccount;
import com.standardchartered.crm.services.AccountService;
import com.standardchartered.crm.services.CustomerService;

public class AccountController {

	private AccountService accountService;
	private CustomerService customerService;

	public AccountController() {
		this.accountService = new AccountService();
		this.customerService =  new CustomerService();
	}

	public void doListAccounts() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Customer Id: ");
		String customerId = scanner.nextLine();
		
		Customer customer = this.customerService.getCustomerOnlyById(Integer.parseInt(customerId));
		System.out.println(customer);
		
		ArrayList<Account> accounts = this.accountService.getAccountsByCustomerId(Integer.parseInt(customerId));
		for (Account account : accounts) {
			System.out.println(account);
		}
	}
	
	public void doViewAccountById() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the Id: ");
		String strId = scanner.next();

		Account account = this.accountService.getAccountById(Integer.parseInt(strId));
		if (account == null) {
			System.out.println("Account does not exist.");
		} else {
			System.out.println(account);
		}
	}

	public void doNewAccount() {
		// Getting input from keyboard

		Scanner scanner = new Scanner(System.in);

		System.out.print("Customer Id:  ");
		String customerId = scanner.nextLine();
		Customer customer = this.customerService.getCustomerById(Integer.parseInt(customerId));
		if(customer == null) {
			System.out.println("Customer does not exist. Please add customer first.\n");
			return;
		}

		System.out.println("Type S for Savings Account ");
		System.out.println("Type C for Current Account ");

		String accountType = scanner.nextLine();
		if (accountType.equals("S")) {
			System.out.print("Account Number: ");
			String accountNumber = scanner.nextLine();
			System.out.print("Branch Name: ");
			String branchName = scanner.nextLine();
			System.out.print("Interest Rate: ");
			String interestRate = scanner.nextLine();

			SavingsAccount savingsAccount = new SavingsAccount(0, accountNumber, branchName, Double.parseDouble(interestRate));
			savingsAccount.setCustomer(this.customerService.getCustomerById(Integer.parseInt(customerId)));
			this.accountService.saveAccount(savingsAccount);

		}else {
			System.out.print("Account Number: ");
			String accountNumber = scanner.nextLine();
			System.out.print("Branch Name: ");
			String branchName = scanner.nextLine();
			System.out.print("Cheque Book Number: ");
			String chequeBookNumber = scanner.nextLine();

			CurrentAccount currentAccount = new CurrentAccount(0, accountNumber, branchName, chequeBookNumber);
			currentAccount.setCustomer(this.customerService.getCustomerById(Integer.parseInt(customerId)));
			this.accountService.saveAccount(currentAccount);
		}

	}

	public void doEditAccount() {

		System.out.print("Enter the Account ID: ");
		Scanner scanner = new Scanner(System.in);
		String strId = scanner.next();
		Account account = this.accountService.getAccountById(Integer.parseInt(strId));

		if (account == null) {
			System.out.println("Customer does not exist");
			return;
		} else {
			if (account instanceof SavingsAccount) {
				SavingsAccount savingsAccount = (SavingsAccount) account;
				System.out.println("Interest Rate: [" + savingsAccount.getInterestRate() + "]");
				String interestRate = scanner.next();
				savingsAccount.setInterestRate(Double.parseDouble(interestRate));
				this.accountService.updateAccount(savingsAccount);
				
			} else {
				CurrentAccount currentAccount = (CurrentAccount) account;
				System.out.println("Cheque Book Number: [" + currentAccount.getCheckbookNumber() + "]");
				String chequeBookNumber = scanner.next();
				currentAccount.setCheckbookNumber(chequeBookNumber);
				this.accountService.updateAccount(currentAccount);
				
			}

		}
	}
	
	public void doDeleteAccount() {

		System.out.print("Enter the ID: ");
		Scanner scanner = new Scanner(System.in);
		String strId = scanner.next();
		this.accountService.deleteAccountById(Integer.parseInt(strId));
		

	}
}
