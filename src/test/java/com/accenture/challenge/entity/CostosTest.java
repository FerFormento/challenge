package com.accenture.challenge.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.challenge.dto.CostoDto;

@SpringBootTest
public class CostosTest {

	@Test
	void testCosto() {
		var costo = new CostoDto(1,2,15);

	    assertEquals(1, costo.origen());
	    assertEquals(2, costo.destino());
	    assertEquals(15, costo.costo());
	}
}
