package com.delcons.authservice.infrastructure.exception;

import com.delcons.authservice.domain.exception.InvalidCredentialsException;
import com.delcons.authservice.domain.exception.TokenExpiredException;
import com.delcons.authservice.domain.exception.TokenInvalidException;
import com.delcons.authservice.domain.exception.UserAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler extends RuntimeException{

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleUserAlreadyExists(UserAlreadyExistsException ex, HttpServletRequest req) {
        ApiErrorResponse body = ApiErrorResponse.of(
                HttpStatus.CONFLICT.value(),
                "USER_ALREADY_EXISTS",
                ex.getMessage() != null ? ex.getMessage() : "El usuario ya existe",
                req.getRequestURI(),
                Map.of()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex, HttpServletRequest req) {
        ApiErrorResponse body = ApiErrorResponse.of(
                HttpStatus.UNAUTHORIZED.value(),
                "INVALID_CREDENTIALS",
                ex.getMessage() != null ? ex.getMessage() : "Credenciales inválidas",
                req.getRequestURI(),
                Map.of()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    @ExceptionHandler({TokenExpiredException.class, TokenInvalidException.class})
    public ResponseEntity<ApiErrorResponse> handleToken(RuntimeException ex, HttpServletRequest req) {
        ApiErrorResponse body = ApiErrorResponse.of(
                HttpStatus.UNAUTHORIZED.value(),
                "TOKEN_INVALID",
                ex.getMessage() != null ? ex.getMessage() : "Token inválido o expirado",
                req.getRequestURI(),
                Map.of()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        Map<String, Object> details = new HashMap<>();
        Map<String, String> fields = new HashMap<>();

        for (FieldError fe : ex.getBindingResult().getFieldErrors()) {
            fields.put(fe.getField(), fe.getDefaultMessage());
        }
        details.put("fields", fields);

        ApiErrorResponse body = ApiErrorResponse.of(
                HttpStatus.BAD_REQUEST.value(),
                "VALIDATION_ERROR",
                "Request inválida",
                req.getRequestURI(),
                details
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest req) {
        ApiErrorResponse body = ApiErrorResponse.of(
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                ex.getMessage(),
                req.getRequestURI(),
                Map.of()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGeneric(Exception ex, HttpServletRequest req) {
        ApiErrorResponse body = ApiErrorResponse.of(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "INTERNAL_ERROR",
                "Error inesperado",
                req.getRequestURI(),
                Map.of()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
