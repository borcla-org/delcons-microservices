package com.delcons.authservice.domain.port.out;

import com.delcons.authservice.domain.model.User;
import com.delcons.authservice.domain.model.valueobject.Email;
import com.delcons.authservice.domain.model.valueobject.Username;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryPort {
    Optional<User> findById(UUID id);

    Optional<User> findByEmail(Email email);

    Optional<User> findByUsername(Username username);

    boolean existsByEmail(Email email);

    boolean existsByUsername(Username username);

    User save(User user);
}
