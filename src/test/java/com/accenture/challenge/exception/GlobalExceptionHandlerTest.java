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


//@WebMvcTest(controllers = GlobalExceptionHandlerTest.TestController.class)
class GlobalExceptionHandlerTest {

//    @Autowired
//	private MockMvc mockMvc;
//    
//    @Mock
//    private GlobalExceptionHandler globalExceptionHandler;
//
//	@RestController
//	static class TestController {
//		@GetMapping("/notfound")
//		public void notFound() {
//			throw new AcreditacionNoEncontradaException(1L);
//		}
//
//		@GetMapping("/invalid")
//		public void invalid() {
//			throw new AcreditacionInvalidaException("Dato inválido");
//		}
//
//		@GetMapping("/error")
//		public void error() {
//			throw new RuntimeException("Fallo");
//		}
//	}
//
//	@Test
//	void testHandleNotFound() throws Exception {
//		mockMvc.perform(get("/notfound")).andExpect(status().isInternalServerError());
//	}
//
//	@Test
//	void testHandleInvalid() throws Exception {
//		mockMvc.perform(get("/invalid")).andExpect(status().isInternalServerError());
//	}
//
//	@Test
//	void testHandleAll() throws Exception {
//		mockMvc.perform(get("/error")).andExpect(status().isInternalServerError());
//	}
//	
//	@Test
//	void testHandleNotFound1() {
//		AcreditacionNoEncontradaException ex;
//		globalExceptionHandler.handleNotFound(ex, req);
//	}
	
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
        assertEquals("acreditacion_not_found", response.getBody().getCode());
        assertEquals("Acreditacion con id 1 no encontrada", response.getBody().getMessage());
        assertEquals("/test-uri", response.getBody().getPath());
        assertNotNull(response.getBody().getTimestamp());
    }

    @Test
    void handleInvalidInput_ShouldReturnBadRequestErrorResponse() {
        AcreditacionInvalidaException ex =
                new AcreditacionInvalidaException("Datos inválidos");

        ResponseEntity<ErrorResponse> response =
                handler.handleInvalidInput(ex, request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("invalid_input", response.getBody().getCode());
        assertEquals("Datos inválidos", response.getBody().getMessage());
        assertEquals("/test-uri", response.getBody().getPath());
        assertNotNull(response.getBody().getTimestamp());
    }

    @Test
    void handleAll_ShouldReturnInternalServerErrorResponse() {
        Exception ex = new Exception("Error genérico");

        ResponseEntity<ErrorResponse> response =
                handler.handleAll(ex, request);

        assertEquals(500, response.getStatusCodeValue());
        assertEquals("internal_error", response.getBody().getCode());
        assertEquals("Error inesperado", response.getBody().getMessage());
        assertEquals("/test-uri", response.getBody().getPath());
        assertNotNull(response.getBody().getTimestamp());
    }
}

