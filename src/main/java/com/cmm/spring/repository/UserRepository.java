package com.cmm.spring.repository;

import com.cmm.spring.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    //User findByuId(String uId); //uId로 사용자 조회.
    //Optional<User> findByUId(String uId); -> 이새끼때문에 실행에러남 uId를 대문자로인식? 미쳣나
    boolean existsByUid(String uid);
}
