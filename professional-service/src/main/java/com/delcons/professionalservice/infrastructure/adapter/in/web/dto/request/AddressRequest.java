package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

import jakarta.validation.constraints.NotBlank;

public record AddressRequest(
        @NotBlank String city,
        @NotBlank String street,
        @NotBlank String zip,
        @NotBlank String country,
        @NotBlank String state
) {
}
