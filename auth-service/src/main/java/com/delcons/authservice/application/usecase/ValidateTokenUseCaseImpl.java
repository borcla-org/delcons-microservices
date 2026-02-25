package com.delcons.authservice.application.usecase;

import com.delcons.authservice.domain.model.valueobject.TokenValue;
import com.delcons.authservice.domain.port.in.ValidateTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateTokenUseCaseImpl implements ValidateTokenUseCase {
    @Override
    public TokenInfo validate(TokenValue accessToken) {
        return null;
    }
}
