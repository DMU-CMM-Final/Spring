package com.cmm.spring.repository;

import com.cmm.spring.entity.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message,Integer> {

}
