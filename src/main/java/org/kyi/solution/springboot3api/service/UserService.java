package org.kyi.solution.springboot3api.service;


import org.kyi.solution.springboot3api.exception.custom.EmailExistException;
import org.kyi.solution.springboot3api.model.User;

public interface UserService {
    User register(String firstName, String lastName, String email, String password) throws EmailExistException;

    User findUserByEmail(String email);

}
