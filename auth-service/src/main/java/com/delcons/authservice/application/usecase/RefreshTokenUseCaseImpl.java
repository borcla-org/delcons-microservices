package com.delcons.authservice.application.usecase;

import com.delcons.authservice.domain.model.valueobject.TokenValue;
import com.delcons.authservice.domain.port.in.RefreshTokenUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefreshTokenUseCaseImpl implements RefreshTokenUseCase {
    @Override
    public RefreshResult refresh(TokenValue refreshToken) {
        return null;
    }
}
