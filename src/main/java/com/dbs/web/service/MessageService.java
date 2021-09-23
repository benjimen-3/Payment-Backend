package com.dbs.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.web.beans.Message;
import com.dbs.web.exceptions.ResourceNotFoundException;
import com.dbs.web.repository.MessageRepository;
@Service
public class MessageService {
	@Autowired
	private MessageRepository repo;
	

	public List<Message> getAllMessageCodes()throws Exception {
		
		List<Message> messages = new ArrayList<Message>();
		this.repo.findAll().forEach(Message-> messages.add(Message));
		return messages;
	}
	
	public Message findById(String msgCode) {
		return repo.findById(msgCode)
				.orElseThrow(() -> new ResourceNotFoundException("The given message code doesn't exists"));
	}


}
