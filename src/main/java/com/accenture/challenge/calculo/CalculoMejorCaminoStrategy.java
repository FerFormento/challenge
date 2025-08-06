package com.accenture.challenge.calculo;

import java.util.Map;

import com.accenture.challenge.dto.ResultadoMejorCaminoDto;

public interface CalculoMejorCaminoStrategy {

	ResultadoMejorCaminoDto calcularCaminoMinimo(int origen, int destino, Map<Integer, Map<Integer, Integer>> grafo);

}
