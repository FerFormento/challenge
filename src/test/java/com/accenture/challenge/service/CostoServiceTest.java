package com.accenture.challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accenture.challenge.calculo.CalculoMejorCaminoStrategy;
import com.accenture.challenge.service.impl.CostoServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CostoServiceTest {

	@Mock
	private CostoService service;

	@Mock
	private CalculoMejorCaminoStrategy calculoMejorCaminoStrategy;

	@BeforeEach
	public void setUp() {
		service = new CostoServiceImpl(calculoMejorCaminoStrategy);
		service.init();
	}

	@Test
	public void testAgregarYConsultarVecinos() {
		service.cargar(11, 12, 7);
		Map<Integer, Integer> vecinos = service.vecinos(11);
		assertEquals(1, vecinos.size());
		assertEquals(7, vecinos.get(12));
	}

	@Test
	public void testEliminarCosto() {
		service.remover(1, 2);
		Map<Integer, Integer> vecinos = service.vecinos(1);
		assertFalse(vecinos.containsKey(2));
	}

	@Test
	public void testCaminoMinimoSimple() {
		var result = service.buscarMejorCamino(1, 5);
		assertNotNull(result);
		assertEquals(16, result.costoTotal);
		assertEquals(List.of(1, 2, 5), result.camino);
	}

}
