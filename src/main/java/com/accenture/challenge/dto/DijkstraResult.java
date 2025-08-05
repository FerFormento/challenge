package com.accenture.challenge.dto;

import java.util.List;

public record DijkstraResult(int costoTotal, List<Integer> camino) {}
