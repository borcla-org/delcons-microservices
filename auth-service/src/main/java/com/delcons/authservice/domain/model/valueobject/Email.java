package com.delcons.authservice.domain.model.valueobject;

import java.util.Objects;

public record Email(String value) {
    public Email {
        Objects.requireNonNull(value, "Email cannot be null");
        String normalizedEmail = value.trim().toLowerCase();
        if(normalizedEmail.isBlank()) {
            throw new IllegalArgumentException("Email cannot be blank");
        }
        if(!normalizedEmail.contains("@")) {
            throw new IllegalArgumentException("Email must contain @");
        }
        value = normalizedEmail;
    }

    public String domain() {
        return value.substring(value.indexOf("@") + 1);
    }
}
