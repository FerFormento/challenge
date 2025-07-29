package com.accenture.challenge.calculo;

import java.util.Map;

import com.accenture.challenge.dto.DijkstraResult;

public interface CalculoMejorCaminoStrategy {

	DijkstraResult calcularCaminoMinimo(int origen, int destino, Map<Integer, Map<Integer, Integer>> grafo);

}
