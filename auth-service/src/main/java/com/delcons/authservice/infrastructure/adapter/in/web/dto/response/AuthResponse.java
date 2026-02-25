package com.delcons.authservice.infrastructure.adapter.in.web.dto.response;

import com.delcons.authservice.domain.port.in.LoginUseCase;
import com.delcons.authservice.domain.port.in.RefreshTokenUseCase;

import java.time.Instant;

public record AuthResponse(
        String accessToken,
        String refreshToken,
        Instant accessTokenExpiresAt
) {

    public static AuthResponse from(LoginUseCase.LoginResult result) {
        return new AuthResponse(
                result.accessToken().value(),
                result.refreshToken().value(),
                result.accessTokenExpiresAt()
        );
    }

    public static AuthResponse from(RefreshTokenUseCase.RefreshResult result) {
        return new AuthResponse(
                result.accessToken().value(),
                result.refreshToken().value(),
                result.accessTokenExpiresAt()
        );
    }
}
