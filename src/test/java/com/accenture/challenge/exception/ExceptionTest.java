package com.accenture.challenge.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExceptionTest {

    @Test
    void testAcreditacionInvalidaException() {
        AcreditacionInvalidaException ex = new AcreditacionInvalidaException("Error");
        assertEquals("Error", ex.getMessage());
    }

    @Test
    void testAcreditacionNoEncontradaException() {
        AcreditacionNoEncontradaException ex = new AcreditacionNoEncontradaException(5L);
        assertTrue(ex.getMessage().contains("5"));
    }
}
