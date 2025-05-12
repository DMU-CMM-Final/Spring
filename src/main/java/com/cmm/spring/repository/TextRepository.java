package com.cmm.spring.repository;

import com.cmm.spring.entity.Text;
import org.springframework.data.repository.CrudRepository;

public interface TextRepository extends CrudRepository<Text,Integer> {
}
