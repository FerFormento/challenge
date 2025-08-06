package com.accenture.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.challenge.dto.AcreditacionDto;
import com.accenture.challenge.entity.Acreditacion;
import com.accenture.challenge.service.AcreditacionService;
import static com.accenture.challenge.constant.Constant.ACREDITARCIONES;

@RestController
@RequestMapping(ACREDITARCIONES)
public class AcreditacionController {

	@Autowired
    private AcreditacionService acreditacionService;

    @PostMapping
    public ResponseEntity<Acreditacion> agregarAcreditacion(@RequestBody AcreditacionDto acreditacionDto) {
    	Acreditacion acreditacion = acreditacionService.cargarAcreditacion(acreditacionDto);
        return ResponseEntity.ok(acreditacion);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acreditacion> consultarAcreditacion(@PathVariable Long id) {
        Acreditacion acreditacion = acreditacionService.consultaAcreditacion(id);
        return ResponseEntity.ok(acreditacion);
    }
    
    @GetMapping
    public ResponseEntity<List<Acreditacion>> consultarTodasAcreditaciones() {
    	List<Acreditacion> lista = acreditacionService.consultaTodasAcreditaciones();
    	return ResponseEntity.ok(lista);
    }
    
}
