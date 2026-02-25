package com.delcons.authservice.domain.port.in;

import com.delcons.authservice.domain.model.valueobject.TokenValue;

import java.time.Instant;

public interface LoginUseCase {
    LoginResult login(LoginCommand command);

    record LoginCommand(String login, char[] password) { }

    record LoginResult(
            TokenValue accessToken,
            TokenValue refreshToken,
            Instant accessTokenExpiresAt
    ) { }
}
