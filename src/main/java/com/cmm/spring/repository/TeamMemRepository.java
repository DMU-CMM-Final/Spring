package com.cmm.spring.repository;

import com.cmm.spring.entity.TeamMem;
import com.cmm.spring.entity.TeamMemId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamMemRepository extends CrudRepository<TeamMem, TeamMemId> {
    List<TeamMem> findByUid(String uid);
}
