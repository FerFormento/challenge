package com.accenture.challenge.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.accenture.challenge.calculo.AStarStrategy;
import com.accenture.challenge.calculo.DijkstraStrategy;
import com.accenture.challenge.constant.MetodoBusquedaEnum;
import com.accenture.challenge.dto.ResultadoMejorCaminoDto;
import com.accenture.challenge.service.CostoService;

import jakarta.annotation.PostConstruct;

@Service
public class CostoServiceImpl implements CostoService {

	private final Map<Integer, Map<Integer, Integer>> cacheCostos = new ConcurrentHashMap<>();
	
	private final DijkstraStrategy dijkstraStrategy;
	private final AStarStrategy aStarStrategy;
	
	@Autowired
	public CostoServiceImpl(@Qualifier("dijkstra") DijkstraStrategy dijkstraStrategy, 
			@Qualifier("astar") AStarStrategy aStarStrategy) {
		this.dijkstraStrategy = dijkstraStrategy;
		this.aStarStrategy = aStarStrategy;
	}

    @PostConstruct
    public void init() {
        cargar(1,2,2); cargar(1,3,3); cargar(2,3,5); cargar(2,4,10); cargar(1,4,11);
        cargar(4,5,5); cargar(2,5,14); cargar(6,7,32); cargar(8,9,11); cargar(10,7,5);
        cargar(3,8,10); cargar(5,8,30); cargar(10,5,5); cargar(4,6,6);
    }

    public void cargar(int a, int b, int costo) {
        if (costo < 0 || a == b) return;
        cacheCostos.computeIfAbsent(a, k -> new HashMap<>()).put(b, costo);
        cacheCostos.computeIfAbsent(b, k -> new HashMap<>()).put(a, costo);
    }

    public void remover(int a, int b) {
        Optional.ofNullable(cacheCostos.get(a)).ifPresent(m -> m.remove(b));
        Optional.ofNullable(cacheCostos.get(b)).ifPresent(m -> m.remove(a));
    }

	public Map<Integer, Integer> vecinos(int id) {
        return cacheCostos.getOrDefault(id, Collections.emptyMap());
    }

    public ResultadoMejorCaminoDto buscarMejorCamino(int origen, int destino, MetodoBusquedaEnum metodo) {
    	ResultadoMejorCaminoDto dijkstraResult = switch (metodo) {
	        case A_STAR -> aStarStrategy.calcularCaminoMinimo(origen, destino, cacheCostos);
	        case DIJKSTRA -> dijkstraStrategy.calcularCaminoMinimo(origen, destino, cacheCostos);
    	};
    	return dijkstraResult;
    }
    
}
