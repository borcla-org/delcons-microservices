package com.delcons.authservice.domain.model;

import com.delcons.authservice.domain.model.enums.Role;
import com.delcons.authservice.domain.model.valueobject.Email;
import com.delcons.authservice.domain.model.valueobject.PasswordHash;
import com.delcons.authservice.domain.model.valueobject.Username;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;


public class User {
    private UUID id;
    private Email email;
    private Username username;
    private PasswordHash passwordHash;
    boolean enabled;
    Set<Role> roles;
    Instant createdAt;
    Instant lastLogin;

    public boolean hasRole(Role role){
        return roles!=null && roles.contains(role);
    }
}
