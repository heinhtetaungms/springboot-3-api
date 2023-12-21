package org.kyi.solution.springboot3api.exception.custom;

public class UsernameExistException extends Exception{
    public UsernameExistException(String message) {
        super(message);
    }
}
