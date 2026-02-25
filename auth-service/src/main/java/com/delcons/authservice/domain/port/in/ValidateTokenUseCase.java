package com.delcons.authservice.domain.port.in;

import com.delcons.authservice.domain.model.valueobject.TokenValue;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

public interface ValidateTokenUseCase {

    TokenInfo validate(TokenValue accessToken);

    record TokenInfo(
            UUID userId,
            String username,
            Set<String> roles,
            Instant expiresAt
    ) { }
}
