package com.accenture.challenge.dto;

import java.math.BigDecimal;

public class AcreditacionDTO {

	private BigDecimal importe;
	
    private Integer puntoVenta;
    
	public BigDecimal getImporte() {
		return importe;
	}
	
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	public Integer getPuntoVenta() {
		return puntoVenta;
	}
	
	public void setPuntoVenta(Integer puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
}
