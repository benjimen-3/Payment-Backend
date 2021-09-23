package com.dbs.web.rest;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.Customer;
import com.dbs.web.beans.ResponsePage;
import com.dbs.web.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins="*")
public class CustomerRestController {
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/{customerid}")
	public ResponseEntity<Object> findCustomerById(@PathVariable String customerid)
	{
		try { 
			Customer cust = this.customerservice.findById(customerid);
			return ResponseEntity.status(HttpStatus.OK)
					.body(cust);
					
			
		}catch (EntityNotFoundException e) {
			System.out.println("error");
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ResponsePage("failure", e.getMessage()));
		}
	}


}