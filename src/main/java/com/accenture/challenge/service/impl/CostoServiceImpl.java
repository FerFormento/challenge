package com.accenture.challenge.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.accenture.challenge.calculo.CalculoMejorCaminoStrategy;
import com.accenture.challenge.dto.DijkstraResult;
import com.accenture.challenge.service.CostoService;

import jakarta.annotation.PostConstruct;

@Service
public class CostoServiceImpl implements CostoService {

	private final Map<Integer, Map<Integer, Integer>> grafo = new ConcurrentHashMap<>();
	
	private static CalculoMejorCaminoStrategy calculoMejorCaminoStrategy;
	
	public CostoServiceImpl(CalculoMejorCaminoStrategy calculoMejorCaminoStrategy) {
		this.calculoMejorCaminoStrategy = calculoMejorCaminoStrategy;
	}

    @PostConstruct
    public void init() {
        // Cargar costos iniciales
        cargar(1,2,2); cargar(1,3,3); cargar(2,3,5); cargar(2,4,10); cargar(1,4,11);
        cargar(4,5,5); cargar(2,5,14); cargar(6,7,32); cargar(8,9,11); cargar(10,7,5);
        cargar(3,8,10); cargar(5,8,30); cargar(10,5,5); cargar(4,6,6);
    }

    public void cargar(int a, int b, int costo) {
        if (costo < 0 || a == b) return;
        grafo.computeIfAbsent(a, k -> new HashMap<>()).put(b, costo);
        grafo.computeIfAbsent(b, k -> new HashMap<>()).put(a, costo);
    }

    public void remover(int a, int b) {
        Optional.ofNullable(grafo.get(a)).ifPresent(m -> m.remove(b));
        Optional.ofNullable(grafo.get(b)).ifPresent(m -> m.remove(a));
    }

	public Map<Integer, Integer> vecinos(int id) {
        return grafo.getOrDefault(id, Collections.emptyMap());
    }

    public DijkstraResult buscarMejorCamino(int origen, int destino) {
    	return calculoMejorCaminoStrategy.calcularCaminoMinimo(origen, destino, grafo);
    }
    
//    public DijkstraResult caminoMinimo(int origen, int destino) {
//        Map<Integer, Integer> dist = new HashMap<>();
//        Map<Integer, Integer> prev = new HashMap<>();
//        Set<Integer> visitados = new HashSet<>();
//        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
//
//        dist.put(origen, 0);
//        queue.add(new int[]{origen, 0});
//
//        while (!queue.isEmpty()) {
//            int[] actual = queue.poll();
//            int nodo = actual[0];
//
//            if (visitados.contains(nodo)) continue;
//            visitados.add(nodo);
//
//            for (Map.Entry<Integer, Integer> vecino : vecinos(nodo).entrySet()) {
//                int v = vecino.getKey();
//                int costo = vecino.getValue();
//                int nuevoCosto = dist.get(nodo) + costo;
//
//                if (nuevoCosto < dist.getOrDefault(v, Integer.MAX_VALUE)) {
//                    dist.put(v, nuevoCosto);
//                    prev.put(v, nodo);
//                    queue.add(new int[]{v, nuevoCosto});
//                }
//            }
//        }
//
//        if (!dist.containsKey(destino)) return null;
//
//        List<Integer> camino = new LinkedList<>();
//        for (Integer at = destino; at != null; at = prev.get(at)) {
//            camino.add(0, at);
//        }
//
//        return new DijkstraResult(dist.get(destino), camino);
//    }

}
