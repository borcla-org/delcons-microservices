package com.delcons.authservice.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequest (
        @NotBlank @Size(min=5, max = 10) String username,
        @NotBlank @Email String email,
        @NotBlank String password
){
}
