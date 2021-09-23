package com.dbs.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.web.beans.Message;
import com.dbs.web.service.MessageService;
@RestController
@RequestMapping()
@CrossOrigin(origins="*")
public class MessageRestController {
	
	@Autowired
	private MessageService messageservice;
	
	@GetMapping("/msgcodes")
	public ResponseEntity<List<Message>> getAllMessageCodes() throws Exception{
		List<Message> msgCodes = messageservice.getAllMessageCodes();
		System.out.println(msgCodes);
		return new ResponseEntity(msgCodes,HttpStatus.OK);
	}

}
