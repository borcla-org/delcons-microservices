package com.delcons.authservice.domain.port.out;

import com.delcons.authservice.domain.model.valueobject.PasswordHash;

public interface PasswordHasherPort {
    PasswordHash hash(char[] rawPassword);
    boolean matches(char[] rawPassword, PasswordHash storedHash);
}
