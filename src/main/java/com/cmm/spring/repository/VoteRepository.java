package com.cmm.spring.repository;

import com.cmm.spring.entity.Vote;
import com.cmm.spring.entity.VoteId;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, VoteId> {
}
