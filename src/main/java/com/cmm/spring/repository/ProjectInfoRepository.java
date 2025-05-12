package com.cmm.spring.repository;

import com.cmm.spring.entity.ProjectInfo;
import org.springframework.data.repository.CrudRepository;

public interface ProjectInfoRepository extends CrudRepository<ProjectInfo,String> {
}
