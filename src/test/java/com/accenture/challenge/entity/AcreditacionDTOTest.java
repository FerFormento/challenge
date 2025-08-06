package com.accenture.challenge.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.challenge.dto.AcreditacionDto;

@SpringBootTest
public class AcreditacionDTOTest {

	@Test
	void testAcreditacionDTO() {
		var dto = new AcreditacionDto(new BigDecimal(12),1);

	    assertEquals(1, dto.puntoVenta());
	    assertEquals(new BigDecimal(12), dto.importe());
	}
}
