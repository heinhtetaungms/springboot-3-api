package org.kyi.solution.springboot3api.exception.custom;

public class EmailNotFoundException extends Exception{
    public EmailNotFoundException(String message) {
        super(message);
    }
}
