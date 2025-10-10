package com.encora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encora.model.User;

public interface UserDetailsRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByUsername(String username);

}
