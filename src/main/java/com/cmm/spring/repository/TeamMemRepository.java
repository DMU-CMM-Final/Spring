package com.cmm.spring.repository;

import com.cmm.spring.entity.TeamMem;
import com.cmm.spring.entity.TeamMemId;
import org.springframework.data.repository.CrudRepository;

public interface TeamMemRepository extends CrudRepository<TeamMem, TeamMemId> {
}
