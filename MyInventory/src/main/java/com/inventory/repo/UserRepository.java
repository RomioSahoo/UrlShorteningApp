package com.inventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inventory.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("Select e from User e where e.email=?1")
	User findByEmail(String email);
	
}
