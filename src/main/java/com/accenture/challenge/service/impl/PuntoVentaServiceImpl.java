package com.accenture.challenge.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.accenture.challenge.dto.PuntoVenta;
import com.accenture.challenge.service.PuntoVentaService;

import jakarta.annotation.PostConstruct;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;


@Service
@CacheConfig(cacheNames = "puntosVenta")
public class PuntoVentaServiceImpl implements PuntoVentaService {

	private final Map<Integer, PuntoVenta> cache = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        // Cargar datos iniciales
        List.of(
            new PuntoVenta(1, "CABA"), new PuntoVenta(2, "GBA_1"), new PuntoVenta(3, "GBA_2"),
            new PuntoVenta(4, "Santa Fe"), new PuntoVenta(5, "Córdoba"), new PuntoVenta(6, "Misiones"),
            new PuntoVenta(7, "Salta"), new PuntoVenta(8, "Chubut"), new PuntoVenta(9, "Santa Cruz"),
            new PuntoVenta(10, "Catamarca")
        ).forEach(pv -> cache.put(pv.getId(), pv));
    }

    public List<PuntoVenta> getAll() {
        return new ArrayList<>(cache.values());
    }

    public PuntoVenta add(PuntoVenta puntoVenta) {
    	return cache.put(puntoVenta.getId(), puntoVenta);
    }

    public PuntoVenta update(PuntoVenta puntoVenta) {
        return cache.put(puntoVenta.getId(), puntoVenta);
    }

    public PuntoVenta delete(int id) {
        return cache.remove(id);
    }

    public PuntoVenta get(int id) {
        return cache.get(id);
    }

    public boolean exists(int id) {
        return cache.containsKey(id);
    }
}
