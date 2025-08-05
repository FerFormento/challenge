package com.accenture.challenge.calculo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.accenture.challenge.dto.DijkstraResult;

@Component
@Qualifier("dijkstra")
public class DijkstraStrategy implements CalculoMejorCaminoStrategy{

	@Override
	public DijkstraResult calcularCaminoMinimo(int origen, int destino, Map<Integer, Map<Integer, Integer>> grafo) {
		Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        Set<Integer> visitados = new HashSet<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        dist.put(origen, 0);
        queue.add(new int[]{origen, 0});

        while (!queue.isEmpty()) {
            int[] actual = queue.poll();
            int nodo = actual[0];

            if (visitados.contains(nodo)) continue;
            visitados.add(nodo);

            for (Map.Entry<Integer, Integer> vecino : vecinos(nodo, grafo).entrySet()) {
                int v = vecino.getKey();
                int costo = vecino.getValue();
                int nuevoCosto = dist.get(nodo) + costo;

                if (nuevoCosto < dist.getOrDefault(v, Integer.MAX_VALUE)) {
                    dist.put(v, nuevoCosto);
                    prev.put(v, nodo);
                    queue.add(new int[]{v, nuevoCosto});
                }
            }
        }

        if (!dist.containsKey(destino)) return null;

        List<Integer> camino = new LinkedList<>();
        for (Integer at = destino; at != null; at = prev.get(at)) {
            camino.add(0, at);
        }

        return new DijkstraResult(dist.get(destino), camino);
	}
	
	public Map<Integer, Integer> vecinos(int id, Map<Integer, Map<Integer, Integer>> grafo) {
        return grafo.getOrDefault(id, Collections.emptyMap());
    }

}
