package com.delcons.authservice.domain.model.valueobject;


import java.util.Objects;

public record TokenValue(String value) {
    public TokenValue {
        Objects.requireNonNull(value, "token");
        String v = value.trim();
        if (v.isBlank()) throw new IllegalArgumentException("token vacío");
        value = v;
    }

    public String masked() {
        if (value.length() <= 6) return "***";
        return value.substring(0, 3) + "***" + value.substring(value.length() - 3);
    }
}