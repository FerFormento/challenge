package com.accenture.challenge.service;

import java.util.Map;

import com.accenture.challenge.constant.MetodoBusquedaEnum;
import com.accenture.challenge.dto.ResultadoMejorCaminoDto;

public interface CostoService {

	void init();

    void cargar(int a, int b, int costo);

    void remover(int a, int b);

    Map<Integer, Integer> vecinos(int id);

    ResultadoMejorCaminoDto buscarMejorCamino(int origen, int destino, MetodoBusquedaEnum metodo);
}
