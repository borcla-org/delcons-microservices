package com.delcons.authservice.application.service;

import com.delcons.authservice.domain.model.User;
import com.delcons.authservice.domain.model.valueobject.Email;
import com.delcons.authservice.domain.model.valueobject.TokenValue;
import com.delcons.authservice.domain.model.valueobject.Username;
import com.delcons.authservice.domain.port.in.LoginUseCase;
import com.delcons.authservice.domain.port.in.RefreshTokenUseCase;
import com.delcons.authservice.domain.port.in.RegisterUseCase;
import com.delcons.authservice.domain.port.in.ValidateTokenUseCase;
import com.delcons.authservice.infrastructure.adapter.in.web.dto.request.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
public class AuthApplicationService {
    private final LoginUseCase loginUseCase;
    private final RegisterUseCase registerUseCase;
    private final RefreshTokenUseCase refreshTokenUseCase;
    private final ValidateTokenUseCase validateTokenUseCase;

    public LoginUseCase.LoginResult login(String login, String password) {
        Objects.requireNonNull(login, "login");
        Objects.requireNonNull(password, "password");

        return loginUseCase.login(new LoginUseCase.LoginCommand(login, password.toCharArray()));
    }

    public User register(String username, String email, String password) {
        Objects.requireNonNull(username, "username");
        Objects.requireNonNull(email, "email");
        Objects.requireNonNull(password, "password");

        return registerUseCase.register(
                new RegisterUseCase.RegisterCommand(
                        new Username(username),
                        new Email(email),
                        password.toCharArray()
                )
        );
    }
    public RefreshTokenUseCase.RefreshResult refresh(String refreshToken) {
        Objects.requireNonNull(refreshToken, "refreshToken");
        return refreshTokenUseCase.refresh(new TokenValue(refreshToken));
    }

    public ValidateTokenUseCase.TokenInfo validate(String accessToken) {
        Objects.requireNonNull(accessToken, "accessToken");
        return validateTokenUseCase.validate(new TokenValue(accessToken));
    }
}
