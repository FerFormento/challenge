package com.accenture.challenge.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.challenge.dto.Costo;

@SpringBootTest
public class CostosTest {

	@Test
	void testCosto() {
		Costo costo = new Costo(1,2,15);

	    assertEquals(1, costo.getOrigen());
	    assertEquals(2, costo.getDestino());
	    assertEquals(15, costo.getCosto());
	}
}
