package com.ttida.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ttida.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // Add custom query methods if needed

}
