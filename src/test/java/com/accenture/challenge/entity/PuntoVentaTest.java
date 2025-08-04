package com.accenture.challenge.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.challenge.dto.PuntoVenta;

@SpringBootTest
public class PuntoVentaTest {

	@Test
	void testPuntoVenta() {
		PuntoVenta puntoVenta = new PuntoVenta(11, "Jujuy");

	    assertEquals(11, puntoVenta.getId());
	    assertEquals("Jujuy", puntoVenta.getNombre());
	}
}
