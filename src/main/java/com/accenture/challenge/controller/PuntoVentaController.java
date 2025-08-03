package com.accenture.challenge.controller;

import java.util.List;

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
import com.accenture.challenge.service.PuntoVentaService;
import static com.accenture.challenge.constant.Constant.PUNTOS_DE_VENTA;

@RestController
@RequestMapping(PUNTOS_DE_VENTA)
public class PuntoVentaController {

    @Autowired
    private PuntoVentaService service;
    
    @GetMapping
    public List<PuntoVenta> getAll() {
        return service.getAll();
    }

    @PostMapping
    public PuntoVenta add(@RequestBody PuntoVenta pv) {
        return service.add(pv);
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
