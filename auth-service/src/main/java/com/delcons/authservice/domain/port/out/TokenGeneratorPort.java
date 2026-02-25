package com.delcons.authservice.domain.port.out;

import com.delcons.authservice.domain.model.User;
import com.delcons.authservice.domain.model.valueobject.TokenValue;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public interface TokenGeneratorPort {
    TokenValue generateAccessToken(User user, Instant issuedAt, Instant expiresAt);
    TokenValue generateRefreshToken(User user, Instant issuedAt, Instant expiresAt);
    TokenClaims validateAccessToken(TokenValue token, Instant now);

    record TokenClaims(
            UUID userId,
            String username,
            Set<String> roles,
            Instant expiresAt
    ) {}
}
