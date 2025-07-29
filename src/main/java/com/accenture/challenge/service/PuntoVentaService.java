package com.accenture.challenge.service;

import java.util.List;

import com.accenture.challenge.dto.PuntoVenta;


public interface PuntoVentaService {

	void init();

    List<PuntoVenta> getAll();

    PuntoVenta add(PuntoVenta puntoVenta);

    PuntoVenta update(PuntoVenta puntoVenta);

    PuntoVenta delete(int id);

    PuntoVenta get(int id);

    boolean exists(int id);
}
