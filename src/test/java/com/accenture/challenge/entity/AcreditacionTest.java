package com.accenture.challenge.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AcreditacionTest {
	
	@Test
	void testGettersSetters() {
	    var a = new Acreditacion();
	    a.setId(1L);
	    a.setImporte(BigDecimal.TEN);
	    a.setPuntoVentaId(5);
	    a.setPuntoVentaNombre("PV1");
	    Timestamp ts = Timestamp.valueOf("2025-08-04 10:00:00");
	    a.setFechaRecepcion(ts);

	    assertEquals(1L, a.getId());
	    assertEquals(BigDecimal.TEN, a.getImporte());
	    assertEquals(5, a.getPuntoVentaId());
	    assertEquals("PV1", a.getPuntoVentaNombre());
	    assertEquals(ts, a.getFechaRecepcion());
	}
}

