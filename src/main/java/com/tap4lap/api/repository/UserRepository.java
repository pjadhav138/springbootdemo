package com.tap4lap.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tap4lap.api.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
}
