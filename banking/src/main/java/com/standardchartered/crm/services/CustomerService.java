package com.standardchartered.crm.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.standardchartered.crm.models.Customer;
import com.standardchartered.crm.utility.Database;

public class CustomerService {

	private final String SQL_SELECT_ALL = "SELECT * FROM customers";
	private final String SQL_SELECT_BYID = "SELECT * FROM customers WHERE id = ?";
	private final String SQL_INSERT = "INSERT INTO customers (firstname, lastname, icnumber, passportnumber)  VALUES(?, ?, ?, ?)";
	private final String SQL_UPDATE = "UPDATE customers SET firstname = ?, lastname = ?, icnumber = ?, passportnumber = ? WHERE id = ?";
	private final String SQL_DELETE = "DELETE FROM customers WHERE id = ?";

	public ArrayList<Customer> getCustomers(){

		ArrayList<Customer> customers = new ArrayList<>();
		Connection connection = null;
		try {
			//loading the driver into jvm
			/*
			 * Class.forName("com.mysql.cj.jdbc.Driver"); connection =
			 * DriverManager.getConnection(
			 * "jdbc:mysql://localhost/standardchartered?serverTimezone=UTC&user=root");
			 */

			// Replace above with below singleton
			connection = Database.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				String icNumber = resultSet.getString(4);
				String passportNumber = resultSet.getString(5);

				Customer customer = new Customer(id, firstName, lastName);
				customer.setIcNumber(icNumber);
				customer.setPassportNumber(passportNumber);
				customers.add(customer);
			}



		} catch (Exception ex) {
			System.out.println(ex);
		}

		return customers;
	}

	public Customer getCustomerById(int id) {
		Customer customer = null;
		Connection connection = null;
		try {
			connection = Database.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_BYID);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int customerId = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				String icNumber = resultSet.getString(4);
				String passportNumber = resultSet.getString(5);

				customer = new Customer(id, firstName, lastName);
				customer.setIcNumber(icNumber);
				customer.setPassportNumber(passportNumber);
			}

		} catch (Exception ex) {
			System.out.println(ex);
		}

		return customer;
	}

	public void saveCustomer(Customer customer) {
		Connection connection = null;
		try {
			connection = Database.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getIcNumber());
			preparedStatement.setString(4, customer.getPassportNumber());
			preparedStatement.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void updateCustomer(Customer customer) {
		Connection connection = null;
		try {
			connection = Database.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE);
			preparedStatement.setString(1, customer.getFirstName());
			preparedStatement.setString(2, customer.getLastName());
			preparedStatement.setString(3, customer.getIcNumber());
			preparedStatement.setString(4, customer.getPassportNumber());
			preparedStatement.setInt(5, customer.getId());

			preparedStatement.executeUpdate();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void deleteCustomerById(int id) {
		Connection connection = null;
		try {
			if (this.getCustomerById(id) != null ) {
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
