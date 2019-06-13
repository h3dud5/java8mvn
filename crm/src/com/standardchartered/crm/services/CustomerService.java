package com.standardchartered.crm.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.standardchartered.crm.models.CurrentAccount;
import com.standardchartered.crm.models.Customer;
import com.standardchartered.crm.models.SavingsAccount;

public class CustomerService {

	public ArrayList<Customer> getCustomers(){
		ArrayList<Customer> customerList = new ArrayList<>();
		try {
			String filePath = System.getProperty("user.dir") + File.separator + "data" + File.separator + "customers.csv" ;
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			String content;
			while((content = bufferedReader.readLine()) != null) {
				StringTokenizer stringTokenizer = new StringTokenizer(content, "," );
				/*
				 * while (stringTokenizer.hasMoreElements()) {
				 * System.out.println(stringTokenizer.nextToken()); }
				 */
				String strId = stringTokenizer.nextToken();
				String firstName = stringTokenizer.nextToken();
				String lastName = stringTokenizer.nextToken();
				String icNumber = stringTokenizer.nextToken();
				String passportNumber = stringTokenizer.nextToken();
				
				Customer customer = new Customer(Integer.parseInt(strId), firstName, lastName);
				customer.setIcNumber(icNumber);
				customer.setPassportNumber(passportNumber);
				
				String accountType = stringTokenizer.nextToken();
				if(accountType.equals("S")) {
					String accountNumber = stringTokenizer.nextToken();
					String branch = stringTokenizer.nextToken();
					String strInterestRate = stringTokenizer.nextToken();
					SavingsAccount savingsAccount = new SavingsAccount(accountNumber, branch, Double.parseDouble(strInterestRate));
					customer.setAccount(savingsAccount);
					
				}else {
					String accountNumber = stringTokenizer.nextToken();
					String branch = stringTokenizer.nextToken();
					String chequeNumber = stringTokenizer.nextToken();
					CurrentAccount currentAccount = new CurrentAccount(accountNumber, branch);
					currentAccount.setCheckbookNumber(chequeNumber);
					customer.setAccount(currentAccount);
					
				}
				customerList.add(customer);
			}
			bufferedReader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customerList;
	}
}
