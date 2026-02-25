package com.delcons.authservice.domain.model.valueobject;

import java.util.Objects;

public record Username(String value) {
    public Username {
        Objects.requireNonNull(value, "username");
        String normalized = value.trim();

        if (normalized.isBlank()) throw new IllegalArgumentException("username vacío");
        if (normalized.length() < 5 || normalized.length() > 10) {
            throw new IllegalArgumentException("username fuera de rango");
        }
        value = normalized;
    }
}
