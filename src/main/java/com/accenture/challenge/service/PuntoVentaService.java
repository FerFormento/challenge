package com.accenture.challenge.service;

import java.util.List;

import com.accenture.challenge.dto.PuntoVentaDto;


public interface PuntoVentaService {

	void init();

    List<PuntoVentaDto> getAll();

    PuntoVentaDto add(PuntoVentaDto puntoVenta);

    PuntoVentaDto update(PuntoVentaDto puntoVenta);

    PuntoVentaDto delete(int id);

    PuntoVentaDto get(int id);

    boolean exists(int id);
}
