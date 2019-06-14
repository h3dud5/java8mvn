package com.standardchartered.crm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.standardchartered.crm.models.Customer;
import com.standardchartered.crm.services.CustomerService;

@WebServlet("/customers")
public class Customers extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException  {

		CustomerService customerService = new CustomerService();
		ArrayList<Customer> customers = customerService.getCustomers();
		
//		res.setContentType("text/plain");
//		res.getWriter().write(customers.toString());
		Gson gson = new Gson();
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(gson.toJson(customers));
		
	}
}
