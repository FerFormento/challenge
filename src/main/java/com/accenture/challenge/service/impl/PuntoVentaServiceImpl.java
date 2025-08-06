package com.accenture.challenge.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.accenture.challenge.dto.PuntoVentaDto;
import com.accenture.challenge.service.PuntoVentaService;

import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


@Service
@CacheConfig(cacheNames = "puntosVenta")
public class PuntoVentaServiceImpl implements PuntoVentaService {

	private final Map<Integer, PuntoVentaDto> cachePuntosVenta = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        List.of(
            new PuntoVentaDto(1, "CABA"), new PuntoVentaDto(2, "GBA_1"), new PuntoVentaDto(3, "GBA_2"),
            new PuntoVentaDto(4, "Santa Fe"), new PuntoVentaDto(5, "Córdoba"), new PuntoVentaDto(6, "Misiones"),
            new PuntoVentaDto(7, "Salta"), new PuntoVentaDto(8, "Chubut"), new PuntoVentaDto(9, "Santa Cruz"),
            new PuntoVentaDto(10, "Catamarca")
        ).forEach(pv -> cachePuntosVenta.put(pv.id(), pv));
    }

    public List<PuntoVentaDto> getAll() {
        return new ArrayList<>(cachePuntosVenta.values());
    }

    public PuntoVentaDto add(PuntoVentaDto puntoVenta) {
    	return cachePuntosVenta.put(puntoVenta.id(), puntoVenta);
    }

    public PuntoVentaDto update(PuntoVentaDto puntoVenta) {
        return cachePuntosVenta.put(puntoVenta.id(), puntoVenta);
    }

    public PuntoVentaDto delete(int id) {
        return cachePuntosVenta.remove(id);
    }

    public PuntoVentaDto get(int id) {
        return cachePuntosVenta.get(id);
    }

    public boolean exists(int id) {
        return cachePuntosVenta.containsKey(id);
    }
}
