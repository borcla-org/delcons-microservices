package com.delcons.professionalservice.domain.exception;

public class ProfessionalNotFoundException extends RuntimeException{
    public ProfessionalNotFoundException(String message) {
        super(message);
    }
}
