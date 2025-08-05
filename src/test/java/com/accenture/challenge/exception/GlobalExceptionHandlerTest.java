package com.accenture.challenge.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;

import com.accenture.challenge.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;


class GlobalExceptionHandlerTest {

	@Mock
	private GlobalExceptionHandler handler;
	@Mock
    private HttpServletRequest request;

    @BeforeEach
    void setUp() {
        handler = new GlobalExceptionHandler();
        request = mock(HttpServletRequest.class);
        when(request.getRequestURI()).thenReturn("/test-uri");
    }

    @Test
    void handleNotFound_ShouldReturnNotFoundErrorResponse() {
        AcreditacionNoEncontradaException ex =
                new AcreditacionNoEncontradaException(1l);

        ResponseEntity<ErrorResponse> response =
                handler.handleNotFound(ex, request);

        assertEquals(404, response.getStatusCodeValue());
        assertEquals("acreditacion_not_found", response.getBody().code());
        assertEquals("Acreditacion con id 1 no encontrada", response.getBody().message());
        assertEquals("/test-uri", response.getBody().path());
        assertNotNull(response.getBody().timestamp());
    }

    @Test
    void handleInvalidInput_ShouldReturnBadRequestErrorResponse() {
        AcreditacionInvalidaException ex =
                new AcreditacionInvalidaException("Datos inválidos");

        ResponseEntity<ErrorResponse> response =
                handler.handleInvalidInput(ex, request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("invalid_input", response.getBody().code());
        assertEquals("Datos inválidos", response.getBody().message());
        assertEquals("/test-uri", response.getBody().path());
        assertNotNull(response.getBody().timestamp());
    }

    @Test
    void handleAll_ShouldReturnInternalServerErrorResponse() {
        Exception ex = new Exception("Error genérico");

        ResponseEntity<ErrorResponse> response =
                handler.handleAll(ex, request);

        assertEquals(500, response.getStatusCodeValue());
        assertEquals("internal_error", response.getBody().code());
        assertEquals("Error inesperado", response.getBody().message());
        assertEquals("/test-uri", response.getBody().path());
        assertNotNull(response.getBody().timestamp());
    }
}

