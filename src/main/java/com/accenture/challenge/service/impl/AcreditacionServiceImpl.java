package com.accenture.challenge.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accenture.challenge.dto.AcreditacionDTO;
import com.accenture.challenge.dto.PuntoVenta;
import com.accenture.challenge.entity.Acreditacion;
import com.accenture.challenge.exception.AcreditacionInvalidaException;
import com.accenture.challenge.exception.AcreditacionNoEncontradaException;
import com.accenture.challenge.repository.AcreditacionRepository;
import com.accenture.challenge.service.AcreditacionService;
import com.accenture.challenge.service.PuntoVentaService;

@Service
public class AcreditacionServiceImpl implements AcreditacionService{

	private final AcreditacionRepository acreditacionRepository;
	
	private final PuntoVentaService puntoVentaService;
	
	public AcreditacionServiceImpl(AcreditacionRepository acreditacionRepository, PuntoVentaService puntoVentaService) {
		this.acreditacionRepository=acreditacionRepository;
		this.puntoVentaService=puntoVentaService;
	}
	
	@Override
	public Acreditacion cargarAcreditacion(AcreditacionDTO acreditacionDto) {
		if (acreditacionDto.getImporte() == null || acreditacionDto.getImporte().compareTo(BigDecimal.ZERO) <= 0) {
            throw new AcreditacionInvalidaException("Importe inválido");
        }
        if (acreditacionDto.getPuntoVenta() == null) {
            throw new AcreditacionInvalidaException("Punto de venta obligatorio");
        }
		
		Acreditacion a = new Acreditacion();
        a.setImporte(acreditacionDto.getImporte());
        a.setPuntoVentaId(acreditacionDto.getPuntoVenta());
        a.setFechaRecepcion(new Timestamp(System.currentTimeMillis()));
        
        PuntoVenta puntoVenta = puntoVentaService.get(acreditacionDto.getPuntoVenta());
        a.setPuntoVentaNombre(puntoVenta.getNombre());
        
        Acreditacion saved = acreditacionRepository.save(a);
        return saved;
	}

	@Override
	public Acreditacion consultaAcreditacion(Long id) {
		Acreditacion acreditacion = acreditacionRepository.findById(id).orElseThrow(() -> new AcreditacionNoEncontradaException(id));
		return acreditacion;
	}

	@Override
	public List<Acreditacion> consultaTodasAcreditaciones() {
		return acreditacionRepository.findAll();
	}

}
