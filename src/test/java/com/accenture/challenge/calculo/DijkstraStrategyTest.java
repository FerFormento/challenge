package com.accenture.challenge.calculo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.accenture.challenge.dto.DijkstraResult;

@SpringBootTest
class DijkstraStrategyTest {

    @Autowired
    private DijkstraStrategy strategy;

    @Test
    void testCaminoEncontrado() {
        Map<Integer, Map<Integer, Integer>> grafo = new HashMap<>();
        grafo.put(1, Map.of(2, 5));
        grafo.put(2, Map.of(3, 10));
        grafo.put(3, Map.of());

        DijkstraResult result = strategy.calcularCaminoMinimo(1, 3, grafo);

        assertNotNull(result);
        assertEquals(15, result.costoTotal());
        assertEquals(List.of(1, 2, 3), result.camino());
    }

    @Test
    void testCaminoNoEncontrado() {
        Map<Integer, Map<Integer, Integer>> grafo = new HashMap<>();
        grafo.put(1, Map.of(2, 5));
        grafo.put(2, Map.of());

        DijkstraResult result = strategy.calcularCaminoMinimo(1, 3, grafo);

        assertNull(result);
    }

    @Test
    void testVecinosInexistente() {
        Map<Integer, Map<Integer, Integer>> grafo = new HashMap<>();
        assertTrue(strategy.vecinos(99, grafo).isEmpty());
    }
}