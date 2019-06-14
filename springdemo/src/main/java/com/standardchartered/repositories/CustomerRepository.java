package com.standardchartered.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.standardchartered.models.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	
}
