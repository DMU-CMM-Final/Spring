package com.cmm.spring.repository;

import com.cmm.spring.entity.ProjectInfo;
import com.cmm.spring.entity.ProjectInfoId;
import org.springframework.data.repository.CrudRepository;

public interface ProjectInfoRepository extends CrudRepository<ProjectInfo, ProjectInfoId> {
}
