package com.delcons.authservice.domain.model;

import lombok.Builder;
import lombok.Value;

import java.time.Instant;
import java.util.UUID;


public class RefreshToken {
    private UUID id;
    private UUID userId;
    private String token;
    private Instant createdAt;
    private Instant expiresAt;
    private boolean revoked;

    public boolean isExpired(Instant now) {
        return expiresAt != null && now != null && now.isAfter(expiresAt);
    }

    public boolean isActive(Instant now) {
        return !revoked && !isExpired(now);
    }
}
