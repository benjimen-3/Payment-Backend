package com.dbs.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dbs.web.beans.Message;
@Repository
public interface MessageRepository  extends CrudRepository<Message, String>{
	

}
