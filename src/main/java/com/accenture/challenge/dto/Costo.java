package com.accenture.challenge.dto;

public class Costo {

	private Integer origen;
    private Integer destino;
    private int costo;
    
    public Costo(Integer origen, Integer destino, int costo) {
    	this.origen = origen;
    	this.destino = destino;
    	this.costo = costo;
    }

	public Integer getOrigen() {
		return origen;
	}

	public void setOrigen(Integer origen) {
		this.origen = origen;
	}

	public Integer getDestino() {
		return destino;
	}

	public void setDestino(Integer destino) {
		this.destino = destino;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

}
