package com.ttida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ttida.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    // Add custom query methods if needed
}
