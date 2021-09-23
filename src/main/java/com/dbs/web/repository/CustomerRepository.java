package com.dbs.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dbs.web.beans.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{

	public Optional<Customer> findById(String customerid);
	

}
