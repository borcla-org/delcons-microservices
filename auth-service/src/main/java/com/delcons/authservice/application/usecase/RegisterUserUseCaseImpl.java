package com.delcons.authservice.application.usecase;

import com.delcons.authservice.domain.model.User;
import com.delcons.authservice.domain.port.in.RegisterUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCaseImpl implements RegisterUseCase {

    @Override
    public User register(RegisterCommand command) {
        return null;
    }
}
