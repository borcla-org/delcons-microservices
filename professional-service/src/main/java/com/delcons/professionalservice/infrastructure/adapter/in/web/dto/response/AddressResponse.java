package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.response;

public record AddressResponse(
    Long id,
    String city,
    String street,
    String zip,
    String country,
    String state
) {}
