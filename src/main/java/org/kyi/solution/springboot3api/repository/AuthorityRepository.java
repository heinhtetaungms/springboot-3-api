package org.kyi.solution.springboot3api.repository;

import org.kyi.solution.springboot3api.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
