package com.accenture.challenge.constant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConstantsTest {

	@Test
	void testConstants() {
	    assertNotNull(Constant.ACREDITARCIONES);
	    assertNotNull(Constant.PUNTOS_DE_VENTA);
	    assertNotNull(Constant.COSTOS);
	}
}
