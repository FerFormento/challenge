package com.accenture.challenge.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.accenture.challenge.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AcreditacionNoEncontradaException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(AcreditacionNoEncontradaException ex, HttpServletRequest req) {
        ErrorResponse err = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            "acreditacion_not_found",
            ex.getMessage(),
            req.getRequestURI(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(AcreditacionInvalidaException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInput(AcreditacionInvalidaException ex, HttpServletRequest req) {
        ErrorResponse err = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "invalid_input",
            ex.getMessage(),
            req.getRequestURI(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception ex, HttpServletRequest req) {
        ErrorResponse err = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "internal_error",
            "Error inesperado",
            req.getRequestURI(),
            LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}

