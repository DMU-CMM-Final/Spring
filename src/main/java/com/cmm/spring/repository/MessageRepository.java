package com.cmm.spring.repository;

import com.cmm.spring.entity.Message;
import com.cmm.spring.entity.MessageId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, MessageId> {
    List<Message> findByUid(String uid);
}
