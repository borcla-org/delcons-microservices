package com.delcons.authservice.infrastructure.adapter.out.persistence.jpa.adapter;

import com.delcons.authservice.domain.model.User;
import com.delcons.authservice.domain.model.valueobject.Email;
import com.delcons.authservice.domain.model.valueobject.Username;
import com.delcons.authservice.domain.port.out.UserRepositoryPort;
import com.delcons.authservice.infrastructure.adapter.out.persistence.jpa.mapper.UserJpaMapper;
import com.delcons.authservice.infrastructure.adapter.out.persistence.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class JpaUserPersistenceAdapter implements UserRepositoryPort {
    private final UserJpaRepository userRepository;
    private final UserJpaMapper userJpaMapper;

    @Override
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id)
                .map(userJpaMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(Email email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(Username username) {
        return Optional.empty();
    }

    @Override
    public boolean existsByEmail(Email email) {
        return false;
    }

    @Override
    public boolean existsByUsername(Username username) {
        return false;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
