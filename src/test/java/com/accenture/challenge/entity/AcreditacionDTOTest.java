package com.accenture.challenge.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.challenge.dto.AcreditacionDTO;

@SpringBootTest
public class AcreditacionDTOTest {

	@Test
	void testAcreditacionDTO() {
		AcreditacionDTO dto = new AcreditacionDTO();
	    dto.setPuntoVenta(1);
	    dto.setImporte(new BigDecimal(12));

	    assertEquals(1, dto.getPuntoVenta());
	    assertEquals(new BigDecimal(12), dto.getImporte());
	}
}
