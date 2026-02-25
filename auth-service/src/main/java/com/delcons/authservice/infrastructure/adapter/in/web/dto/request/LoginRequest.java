package com.delcons.authservice.infrastructure.adapter.in.web.dto.request;

public record LoginRequest(
        String login,
        String password
) {
}
