package com.delcons.professionalservice.infrastructure.adapter.in.web.dto.request;

public record AddressRequest(
    Long id,
    String city,
    String street,
    String zip,
    String country,
    String state
) {}
