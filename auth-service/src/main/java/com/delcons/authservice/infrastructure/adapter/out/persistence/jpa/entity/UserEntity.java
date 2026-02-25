package com.delcons.authservice.infrastructure.adapter.out.persistence.jpa.entity;

import com.delcons.authservice.domain.model.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.jspecify.annotations.Nullable;



import java.time.Instant;
import java.util.*;

@Entity
@Data
@Table(name = "users")
public class UserEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(nullable = false, length = 320, unique = true)
    private String email;

    @Column(nullable = false, length = 50, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String passwordHash;

    @Column(nullable = false)
    private boolean enabled = true;


    @Column(nullable = false, length = 50)
    private Set<Role> roles = new HashSet<>();

    @Column(updatable = false)
    private Instant createdAt;

    private Instant lastLogin;

    @PrePersist
    void prePersist() {
        if (id == null) id = UUID.randomUUID();
        if (createdAt == null) createdAt = Instant.now();
    }
}
