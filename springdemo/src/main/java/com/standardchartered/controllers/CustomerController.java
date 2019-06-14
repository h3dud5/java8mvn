package com.standardchartered.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.standardchartered.models.Customer;
import com.standardchartered.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/customers", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getCustomers(){
		List<Customer> customers = this.customerService.findAll();
		return customers;
	}
	
}
