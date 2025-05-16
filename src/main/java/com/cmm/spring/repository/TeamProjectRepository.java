package com.cmm.spring.repository;

import com.cmm.spring.entity.TeamProject;
import com.cmm.spring.entity.TeamProjectId;
import org.springframework.data.repository.CrudRepository;

public interface TeamProjectRepository extends CrudRepository<TeamProject, TeamProjectId> {
}
