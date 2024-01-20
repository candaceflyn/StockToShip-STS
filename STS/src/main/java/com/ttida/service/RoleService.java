package com.ttida.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ttida.repository.RoleRepository;
import com.ttida.model.Role;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

//    private final RoleRepository roleRepository;
//
//    @Autowired
//    public RoleService(RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//    }
	@Autowired
	private RoleRepository roleRepository;

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(int roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    public void deleteRole(int roleId) {
        roleRepository.deleteById(roleId);
    }

    public String updateRole(int roleId, Role updatedRole) {
        Optional<Role> existingRole = roleRepository.findById(roleId);
        if (existingRole.isPresent()) {
            Role role = existingRole.get();
            role.setRole(updatedRole.getRole());
            roleRepository.save(role);
            return updatedRole + " updated successfully";
        } else {
            return "Role not found";
        }
    }

    public List<Role> saveRoles(List<Role> roles) {
        return roleRepository.saveAll(roles);
    }
}
