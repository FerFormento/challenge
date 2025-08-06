package com.accenture.challenge.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.challenge.dto.PuntoVentaDto;

@SpringBootTest
public class PuntoVentaTest {

	@Test
	void testPuntoVenta() {
		var puntoVenta = new PuntoVentaDto(11, "Jujuy");

	    assertEquals(11, puntoVenta.id());
	    assertEquals("Jujuy", puntoVenta.nombre());
	}
}
