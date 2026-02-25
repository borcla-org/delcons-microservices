package com.delcons.authservice.domain.port.in;

import com.delcons.authservice.domain.model.valueobject.TokenValue;

import java.time.Instant;

public interface RefreshTokenUseCase {
    RefreshResult refresh(TokenValue refreshToken);

    record RefreshResult(
            TokenValue accessToken,
            TokenValue refreshToken,
            Instant accessTokenExpiresAt
    ) { }
}
