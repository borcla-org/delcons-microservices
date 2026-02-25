package com.delcons.authservice.domain.port.out;

import com.delcons.authservice.domain.model.RefreshToken;
import com.delcons.authservice.domain.model.valueobject.TokenValue;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RefreshTokenRepositoryPort {

    Optional<RefreshToken> findByToken(TokenValue token);

    List<RefreshToken> findActiveByUserId(UUID userId);

    RefreshToken save(RefreshToken refreshToken);

    void revoke(TokenValue token);

    void revokeAllByUserId(UUID userId);
}
