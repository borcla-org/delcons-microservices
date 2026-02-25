package com.delcons.professionalservice.domain.exception;


public class ProfessionalAlreadyExistsException extends RuntimeException {

    public ProfessionalAlreadyExistsException(String message) {
        super(message);
    }

    public static ProfessionalAlreadyExistsException withEmail(String email) {
        return new ProfessionalAlreadyExistsException("Professional with email " + email + " already exists");
    }

    public static ProfessionalAlreadyExistsException withNickname(String nickname) {
        return new ProfessionalAlreadyExistsException("Professional with nickname " + nickname + " already exists");
    }
}