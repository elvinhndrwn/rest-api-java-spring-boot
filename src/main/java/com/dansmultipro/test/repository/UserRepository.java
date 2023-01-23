package com.dansmultipro.test.repository;

import com.dansmultipro.test.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
	
	UserModel findByUsername(String username);
	
}