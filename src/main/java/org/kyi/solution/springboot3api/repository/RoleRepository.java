package org.kyi.solution.springboot3api.repository;


import org.kyi.solution.springboot3api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findRoleByName(String name);

}