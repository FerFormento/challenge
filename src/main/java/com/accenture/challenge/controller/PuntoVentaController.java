package com.accenture.challenge.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.challenge.dto.PuntoVenta;
import com.accenture.challenge.dto.PuntoVentaDTO;
import com.accenture.challenge.mapper.PuntoVentaMapper;
import com.accenture.challenge.service.PuntoVentaService;

@RestController
@RequestMapping("/puntos-venta")
public class PuntoVentaController {

    @Autowired
    private PuntoVentaService service;
    
    @Autowired
    private PuntoVentaMapper mapper;
    
    public PuntoVentaController(PuntoVentaService service, PuntoVentaMapper mapper) {
    	this.service=service;
    	this.mapper=mapper;
    }

    @GetMapping
    public List<PuntoVentaDTO> getAll() {
    	return service.getAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public PuntoVentaDTO add(@RequestBody PuntoVentaDTO dto) {
        PuntoVenta saved = service.add(mapper.fromDTO(dto));
        return mapper.toDTO(saved);
    }

    @PutMapping
    public PuntoVenta update(@RequestBody PuntoVenta pv) {
        return service.update(pv);
    }

    @DeleteMapping("/{id}")
    public PuntoVenta delete(@PathVariable int id) {
        return service.delete(id);
    }
}
