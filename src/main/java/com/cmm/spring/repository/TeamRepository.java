package com.cmm.spring.repository;

import com.cmm.spring.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
