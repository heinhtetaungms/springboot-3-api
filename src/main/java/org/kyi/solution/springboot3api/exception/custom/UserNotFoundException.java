package org.kyi.solution.springboot3api.exception.custom;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
