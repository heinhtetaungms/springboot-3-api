package org.kyi.solution.springboot3api.service;


import org.kyi.solution.springboot3api.model.Authority;

import java.util.List;

public interface AuthorityService {
    Authority createAuthority(Authority authority);

    Authority updateAuthority(Authority authority);

    void deleteAuthority(String authorityId);

    Authority getAuthorityById(String authorityId);

    List<Authority> getAllAuthorities();
}
