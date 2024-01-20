package com.ttida.model;

import jakarta.persistence.*;

@Entity
@Table(name="user_tab")
public class UserTab {

    @Id
    private String username;

    private String name;

    private String password;

    private String email;

    private String employeeId;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Transient
    private String enteredPassword;
    
    public UserTab() {
        this.department = new Department(5, "Sales");
        this.role = new Role(1, "User");
    }

    public UserTab(String username, String name, String password, String email, String employeeId) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.employeeId = employeeId;
        this.department = new Department(5, "Sales");
        this.role = new Role(1, "User");
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public String getEnteredPassword() {
		return enteredPassword;
	}

	public void setEnteredPassword(String enteredPassword) {
		this.enteredPassword = enteredPassword;
	}

	public boolean validateEnteredPassword(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }
   
}
