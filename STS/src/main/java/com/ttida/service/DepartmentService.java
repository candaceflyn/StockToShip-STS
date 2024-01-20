package com.ttida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttida.model.Department;
import com.ttida.repository.DepartmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

//    private final DepartmentRepository departmentRepository;
//
//    @Autowired
//    public DepartmentService(DepartmentRepository departmentRepository) {
//        this.departmentRepository = departmentRepository;
//    }
	@Autowired
	private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartment(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    public String updateDepartment(int departmentId, Department updatedDepartment) {
        Optional<Department> existingDepartment = departmentRepository.findById(departmentId);
        if (existingDepartment.isPresent()) {
            Department department = existingDepartment.get();
            department.setDepartmentName(updatedDepartment.getDepartmentName());
            departmentRepository.save(department);
            return updatedDepartment + " updated successfully";
        } else {
            return "Department not found";
        }
    }

    public List<Department> saveDepartments(List<Department> departments) {
        return departmentRepository.saveAll(departments);
    }
}

