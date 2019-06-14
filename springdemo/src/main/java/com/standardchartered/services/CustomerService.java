package com.standardchartered.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.standardchartered.models.Customer;
import com.standardchartered.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> findAll(){
		return (List<Customer>) this.customerRepository.findAll();
	}
}
