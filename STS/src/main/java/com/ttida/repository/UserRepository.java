package com.ttida.repository;

import com.ttida.model.UserTab;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserTab, String> {
	
	Optional<UserTab> findByUsername(String username);

}
