package com.delcons.authservice.infrastructure.adapter.in.web;

import com.delcons.authservice.application.service.AuthApplicationService;
import com.delcons.authservice.domain.port.in.LoginUseCase;
import com.delcons.authservice.domain.port.in.RefreshTokenUseCase;
import com.delcons.authservice.domain.port.in.ValidateTokenUseCase;
import com.delcons.authservice.infrastructure.adapter.in.web.dto.request.LoginRequest;
import com.delcons.authservice.infrastructure.adapter.in.web.dto.request.RegisterRequest;
import com.delcons.authservice.infrastructure.adapter.in.web.dto.response.AuthResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthApplicationService service;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        LoginUseCase.LoginResult result = service.login(request.login(), request.password());
        return ResponseEntity.ok(AuthResponse.from(result));
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@Valid @RequestBody RegisterRequest request) {
        service.register(request.username(), request.email(), request.password());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@RequestParam("refreshToken") String refreshToken) {
        RefreshTokenUseCase.RefreshResult result = service.refresh(refreshToken);
        return ResponseEntity.ok(AuthResponse.from(result));
    }

    @GetMapping("/validate")
    public ResponseEntity<ValidateTokenUseCase.TokenInfo> validate(
            @RequestHeader("Authorization") String authorization
    ) {
        String token = authorization.replace("Bearer", "").trim();
        return ResponseEntity.ok(service.validate(token));
    }
}
