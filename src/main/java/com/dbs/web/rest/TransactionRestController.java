package com.dbs.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.dbs.web.beans.Transaction;
import com.dbs.web.dto.TransactionRequestDto;
import com.dbs.web.service.TransactionService;
@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/transaction")
public class TransactionRestController {
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping()
	public ResponseEntity<Transaction> processTransaction(@RequestBody TransactionRequestDto transactionDto){
		Transaction trans = transactionService.saveTransaction(transactionDto);
		return new ResponseEntity<>(trans,HttpStatus.OK);
	}
	
}