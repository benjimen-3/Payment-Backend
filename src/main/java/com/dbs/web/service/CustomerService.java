package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Customer;
import com.dbs.web.exceptions.ResourceNotFoundException;
import com.dbs.web.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository repo;
    
    public String insertCustomer(Customer customer) {
        if(this.repo.findById(customer.getCustomerid()).isPresent())
            return "not inserted";
        try {
            return this.repo.save(customer).getCustomerid();
        }
        catch(IllegalArgumentException iae) {
            return "not inserted";
        }
    }
    
    public boolean deleteCustomer(String id) throws Exception {
        try {
            this.repo.deleteById(id);
        }catch(IllegalArgumentException e )
        {
            
            throw new IllegalArgumentException("Could not delete");
        }
        catch(Exception e)
        {
            throw new Exception(e);
        }
        return true;
            
        }
    
    public boolean updateCustomer(Customer customer) {
        try {
            this.repo.save(customer);
        }
        catch(IllegalArgumentException iae) {
            return false;
        }
        return true;
    }
    
    public Customer findById(String acctNo) {
		return repo.findById(acctNo)
				.orElseThrow(() -> new ResourceNotFoundException("The given account number doesn't exists"));
	}
    
    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        this.repo.findAll().forEach(cust->customers.add(cust));
        return customers;
    }
    }
    