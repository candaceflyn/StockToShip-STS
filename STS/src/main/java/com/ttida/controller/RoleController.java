package com.ttida.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ttida.model.Role;
import com.ttida.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

//    private final RoleService roleService;
//
//    @Autowired
//    public RoleController(RoleService roleService) {
//        this.roleService = roleService;
//    }
	@Autowired
	private RoleService roleService;

    @GetMapping("/getAllRoles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/getRole/{id}")
    public Role getRoleById(@PathVariable int id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("/saveRole")
    public String saveRole(@RequestBody Role role) {
        roleService.saveRole(role);
        return "Role data saved as : " + role;
    }

    @PostMapping("/saveRoles")
    public List<Role> saveRoles(@RequestBody List<Role> roles) {
        return roleService.saveRoles(roles);
    }

    @PutMapping("/updateRole/{id}")
    public String updateRole(@PathVariable int id, @RequestBody Role updatedRole) {
        String result = roleService.updateRole(id, updatedRole);
        return result;
    }

    @DeleteMapping("/{id}")
    public String deleteRole(@PathVariable int id) {
        roleService.deleteRole(id);
        return "Role deleted with id : " + id;
    }
}

