package com.example.goshopping.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUidAndUpw(String uid, String upw);
    boolean existsByUid(String uid);
    User findByUid(String uid);
	User findFirstByUid(String userId);
}
