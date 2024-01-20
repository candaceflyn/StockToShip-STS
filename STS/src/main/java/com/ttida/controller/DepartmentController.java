package com.ttida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ttida.model.Department;
import com.ttida.service.DepartmentService;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    //private final DepartmentService departmentService;

    //@Autowired
    //public DepartmentController(DepartmentService departmentService) {
     //   this.departmentService = departmentService;
   // }
	@Autowired
	private DepartmentService departmentService;

    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/getDepartment/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/saveDepartment")
    public String saveDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        return "Department data saved as : " + department;
    }

    @PostMapping("/saveDepartments")
    public List<Department> saveDepartments(@RequestBody List<Department> departments) {
        return departmentService.saveDepartments(departments);
    }

    @PutMapping("/updateDepartment/{id}")
    public String updateDepartment(@PathVariable int id, @RequestBody Department updatedDepartment) {
        String result = departmentService.updateDepartment(id, updatedDepartment);
        return result;
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return "Department deleted with id : " + id;
    }
}
