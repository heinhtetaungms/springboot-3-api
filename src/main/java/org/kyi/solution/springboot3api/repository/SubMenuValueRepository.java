package org.kyi.solution.springboot3api.repository;


import org.kyi.solution.springboot3api.model.SubMenuValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubMenuValueRepository extends JpaRepository<SubMenuValue, String> {
}
