package com.delcons.authservice.domain.model.valueobject;

import java.util.Objects;

public record PasswordHash(String value) {
    public PasswordHash {
        Objects.requireNonNull(value, "passwordHash");
        String v = value.trim();
        if (v.isBlank()) throw new IllegalArgumentException("passwordHash vacío");
        value = v;
    }
}
