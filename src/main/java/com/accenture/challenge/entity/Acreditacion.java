package com.accenture.challenge.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Acreditacion {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private BigDecimal importe;
    
    private Integer puntoVentaId;
    
    private String puntoVentaNombre;
    
    private Timestamp fechaRecepcion;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getImporte() {
		return importe;
	}
	
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Integer getPuntoVentaId() {
		return puntoVentaId;
	}

	public void setPuntoVentaId(Integer puntoVentaId) {
		this.puntoVentaId = puntoVentaId;
	}

	public String getPuntoVentaNombre() {
		return puntoVentaNombre;
	}

	public void setPuntoVentaNombre(String puntoVentaNombre) {
		this.puntoVentaNombre = puntoVentaNombre;
	}

	public Timestamp getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Timestamp fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

}

