package com.accenture.challenge.dto;

import java.util.List;

public class DijkstraResult {

	public int costoTotal;
    public List<Integer> camino;

    public DijkstraResult(int costo, List<Integer> camino) {
        this.costoTotal = costo;
        this.camino = camino;
    }

	public int getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(int costoTotal) {
		this.costoTotal = costoTotal;
	}

	public List<Integer> getCamino() {
		return camino;
	}

	public void setCamino(List<Integer> camino) {
		this.camino = camino;
	}
}
