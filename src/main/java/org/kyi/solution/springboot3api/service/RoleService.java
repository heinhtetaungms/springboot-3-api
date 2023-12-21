package org.kyi.solution.springboot3api.service;


import org.kyi.solution.springboot3api.model.Role;

import java.util.List;

public interface RoleService {
    Role createRole(Role role);

    Role updateRole(Role role);

    void deleteRole(String roleId);

    Role getRoleById(String roleId);

    List<Role> getAllRoles();
}
