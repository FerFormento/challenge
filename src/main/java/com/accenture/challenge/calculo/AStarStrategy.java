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
@Qualifier("astar")
public class AStarStrategy implements CalculoMejorCaminoStrategy {

    @Override
    public DijkstraResult calcularCaminoMinimo(int origen, int destino, Map<Integer, Map<Integer, Integer>> grafo) {
        Map<Integer, Integer> gScore = new HashMap<>();
        Map<Integer, Integer> prev = new HashMap<>();
        Set<Integer> visitados = new HashSet<>();

        PriorityQueue<int[]> openSet = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        gScore.put(origen, 0);
        openSet.add(new int[]{origen, heuristic(origen, destino)});

        while (!openSet.isEmpty()) {
            int[] actual = openSet.poll();
            int nodo = actual[0];

            if (nodo == destino) {
                return reconstruirCamino(prev, destino, gScore.get(destino));
            }

            if (visitados.contains(nodo)) continue;
            visitados.add(nodo);

            for (Map.Entry<Integer, Integer> vecino : vecinos(nodo, grafo).entrySet()) {
                int v = vecino.getKey();
                int costo = vecino.getValue();
                int tentativeG = gScore.get(nodo) + costo;

                if (tentativeG < gScore.getOrDefault(v, Integer.MAX_VALUE)) {
                    gScore.put(v, tentativeG);
                    prev.put(v, nodo);
                    int fScore = tentativeG + heuristic(v, destino);
                    openSet.add(new int[]{v, fScore});
                }
            }
        }

        return null;
    }

    private int heuristic(int nodo, int destino) {
        return 0;
    }

    private Map<Integer, Integer> vecinos(int id, Map<Integer, Map<Integer, Integer>> grafo) {
        return grafo.getOrDefault(id, Collections.emptyMap());
    }

    private DijkstraResult reconstruirCamino(Map<Integer, Integer> prev, int destino, int costoTotal) {
        List<Integer> camino = new LinkedList<>();
        for (Integer at = destino; at != null; at = prev.get(at)) {
            camino.add(0, at);
        }
        return new DijkstraResult(costoTotal, camino);
    }
}