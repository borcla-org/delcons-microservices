package com.delcons.authservice.domain.exception;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException() {
        super("Invalid credentials.");
    }

    public InvalidCredentialsException(String message) {
        super(message);
    }
}
