package org.kyi.solution.springboot3api.repository;


import org.kyi.solution.springboot3api.model.SubMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuRepository extends JpaRepository<SubMenu, String> {
}
