package com.accenture.challenge.controller;

import static com.accenture.challenge.constant.Constant.COSTOS;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.challenge.constant.MetodoBusquedaEnum;
import com.accenture.challenge.dto.DijkstraResult;
import com.accenture.challenge.dto.PuntoVenta;
import com.accenture.challenge.service.CostoService;
import com.accenture.challenge.service.PuntoVentaService;

@RestController
@RequestMapping(COSTOS)
public class CostoController {

    @Autowired
    private CostoService costoService;

    @Autowired
    private PuntoVentaService puntoVentaService;

    @PostMapping
    public void agregarCosto(@RequestParam int a, @RequestParam int b, @RequestParam int costo) {
        costoService.cargar(a, b, costo);
    }

    @DeleteMapping
    public void eliminarCosto(@RequestParam int a, @RequestParam int b) {
        costoService.remover(a, b);
    }

    @GetMapping("/vecinos/{id}")
    public Map<String, Integer> vecinos(@PathVariable int id) {
        Map<String, Integer> vecinos = new HashMap<>();
        costoService.vecinos(id).forEach((k, v) -> {
            String nombre = Optional.ofNullable(puntoVentaService.get(k)).map(PuntoVenta::nombre).orElse("Desconocido");
            vecinos.put(nombre, v);
        });
        return vecinos;
    }

    @GetMapping("/camino-minimo")
    public Map<String, Object> caminoMinimo(@RequestParam int origen, @RequestParam int destino, @RequestParam MetodoBusquedaEnum metodo) {
        DijkstraResult result = costoService.buscarMejorCamino(origen, destino, metodo);
        if (result == null) {
            return Map.of("mensaje", "No hay camino entre los puntos seleccionados");
        }
        List<Integer> camino = result.camino();
        List<String> caminoConNombres = camino.stream()
            .map(id -> Optional.ofNullable(puntoVentaService.get(id)).map(PuntoVenta::nombre).orElse("Desconocido"))
            .collect(Collectors.toList());
        return Map.of(
            "costo", result.costoTotal(),
            "camino", caminoConNombres
        );
    }
}
