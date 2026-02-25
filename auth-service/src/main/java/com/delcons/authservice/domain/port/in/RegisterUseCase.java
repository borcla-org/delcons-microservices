package com.delcons.authservice.domain.port.in;

import com.delcons.authservice.domain.model.User;
import com.delcons.authservice.domain.model.valueobject.Email;
import com.delcons.authservice.domain.model.valueobject.Username;

public interface RegisterUseCase {

    User register(RegisterCommand command);

    record RegisterCommand(
            Username username,
            Email email,
            char[] password
    ) { }
}
