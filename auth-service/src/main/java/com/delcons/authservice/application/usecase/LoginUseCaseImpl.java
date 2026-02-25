package com.delcons.authservice.application.usecase;

import com.delcons.authservice.domain.port.in.LoginUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    @Override
    public LoginResult login(LoginCommand command) {
        return null;
    }
}
