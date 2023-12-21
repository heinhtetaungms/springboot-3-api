package org.kyi.solution.springboot3api.exception.custom;

public class EmailExistException extends Exception{
    public EmailExistException(String message) {
        super(message);
    }
}
