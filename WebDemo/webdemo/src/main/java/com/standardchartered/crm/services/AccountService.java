package com.standardchartered.crm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.standardchartered.crm.models.Account;
import com.standardchartered.crm.models.CurrentAccount;
import com.standardchartered.crm.models.SavingsAccount;
import com.standardchartered.crm.utility.Database;

public class AccountService {

	private final String SQL_SELECT_BYID = "SELECT * FROM accounts WHERE id = ?";
	private final String SQL_SELECT_BYCUSTOMERID = "SELECT * FROM accounts WHERE customerid = ?";
	private final String SQL_INSERT = "INSERT INTO accounts (customerid, accounttype, accountnumber, branchname, interestrate, chequebooknumber)  VALUES(?, ?, ?, ?, ?, ?)";
	private final String SQL_UPDATE = "UPDATE accounts SET interestrate = ?, chequebooknumber = ? WHERE id = ?";
	private final String SQL_DELETE = "DELETE FROM accounts WHERE id = ?";

//	private CustomerService customerService = new CustomerService();

	public ArrayList<Account> getAccountsByCustomerId(int customerId){

		ArrayList<Account> accounts = new ArrayList<>();
		Connection connection = null;
		try {
			connection = Database.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BYCUSTOMERID);
			preparedStatement.setInt(1, customerId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				int custId = resultSet.getInt(2);
				String accountType = resultSet.getString(3);
				String accountNumber = resultSet.getString(4);
				String branchName = resultSet.getString(5);
				Double interestRate = resultSet.getDouble(6);
				String chequeBookNumber = resultSet.getString(7);

				if (accountType.equals("S")){
					SavingsAccount savingsAccount = new SavingsAccount(id, accountNumber, branchName, interestRate);
					CustomerService customerService = new CustomerService();
					savingsAccount.setCustomer(customerService.getCustomerById(custId));
					accounts.add(savingsAccount);
				} else {
					CurrentAccount currentAccount = new CurrentAccount(id, accountNumber, branchName, chequeBookNumber);
					CustomerService customerService = new CustomerService();
					currentAccount.setCustomer(customerService.getCustomerById(custId));
					accounts.add(currentAccount);
				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return accounts;
	}
	
	public ArrayList<Account> getAccountsOnlyByCustomerId(int customerId){

		ArrayList<Account> accounts = new ArrayList<>();
		Connection connection = null;
		try {
			connection = Database.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BYCUSTOMERID);
			preparedStatement.setInt(1, customerId);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				int custId = resultSet.getInt(2);
				String accountType = resultSet.getString(3);
				String accountNumber = resultSet.getString(4);
				String branchName = resultSet.getString(5);
				Double interestRate = resultSet.getDouble(6);
				String chequeBookNumber = resultSet.getString(7);

				if (accountType.equals("S")){
					SavingsAccount savingsAccount = new SavingsAccount(id, accountNumber, branchName, interestRate);
//					savingsAccount.setCustomer(this.customerService.getCustomerById(custId));
					accounts.add(savingsAccount);
				} else {
					CurrentAccount currentAccount = new CurrentAccount(id, accountNumber, branchName, chequeBookNumber);
//					currentAccount.setCustomer(this.customerService.getCustomerById(custId));
					accounts.add(currentAccount);
				}
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return accounts;
	}

	public Account getAccountById(int id) {
		Account account = null;
		Connection connection = null;
		try {
			connection = Database.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BYID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int accountId = resultSet.getInt(1);
				int custId = resultSet.getInt(2);
				String accountType = resultSet.getString(3);
				String accountNumber = resultSet.getString(4);
				String branchName = resultSet.getString(5);
				Double interestRate = resultSet.getDouble(6);
				String chequeBookNumber = resultSet.getString(7);

				if (accountType.equals("S")){
					account = new SavingsAccount(id, accountNumber, branchName, interestRate);
					CustomerService customerService = new CustomerService();
					account.setCustomer(customerService.getCustomerById(custId));
				} else {
					account = new CurrentAccount(id, accountNumber, branchName, chequeBookNumber);
					CustomerService customerService = new CustomerService();
					account.setCustomer(customerService.getCustomerById(custId));
				}

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return account;
	}

	public void saveAccount(Account account) {
		Connection connection = null;
		try {
			connection = Database.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);


			if (account instanceof SavingsAccount) {
				SavingsAccount savingsAccount = (SavingsAccount) account;
				preparedStatement.setInt(1, savingsAccount.getCustomer().getId());
				preparedStatement.setString(2, "S");
				preparedStatement.setString(3, savingsAccount.getAccountNumber());
				preparedStatement.setString(4, savingsAccount.getBranchName());
				preparedStatement.setDouble(5, savingsAccount.getInterestRate());
				preparedStatement.setString(6, " ");

			} else {
				CurrentAccount currentAccount = (CurrentAccount) account;
				preparedStatement.setInt(1, currentAccount.getCustomer().getId());
				preparedStatement.setString(2, "C");
				preparedStatement.setString(3, currentAccount.getAccountNumber());
				preparedStatement.setString(4, currentAccount.getBranchName());
				preparedStatement.setDouble(5, 0);
				preparedStatement.setString(6, currentAccount.getCheckbookNumber());
			}

			preparedStatement.executeUpdate();

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateAccount(Account account) {
		Connection connection = null;
		try {
			connection = Database.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);

			if (account instanceof SavingsAccount) {
				SavingsAccount savingsAccount = (SavingsAccount) account;
				preparedStatement.setDouble(1,  savingsAccount.getInterestRate());
				preparedStatement.setString(2,  "");
				preparedStatement.setInt(3, savingsAccount.getId());
			} else {
				CurrentAccount currentAccount = (CurrentAccount) account;
				preparedStatement.setDouble(1, 0);
				preparedStatement.setString(2,  currentAccount.getCheckbookNumber());
				preparedStatement.setInt(3, currentAccount.getId());
			}

			preparedStatement.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void deleteAccountById(int id) {
		Connection connection = null;
		try {
			if (this.getAccountById(id) != null) {
				connection = Database.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE);
				preparedStatement.setInt(1, id);

				preparedStatement.executeUpdate();
			} else {
				System.out.println("ID does not exist");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
}
