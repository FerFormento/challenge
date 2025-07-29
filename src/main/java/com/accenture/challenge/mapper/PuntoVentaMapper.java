package com.accenture.challenge.mapper;

import org.springframework.stereotype.Component;

import com.accenture.challenge.dto.PuntoVenta;
import com.accenture.challenge.dto.PuntoVentaDTO;

@Component
public class PuntoVentaMapper {

    public PuntoVentaDTO toDTO(PuntoVenta pv) {
        PuntoVentaDTO dto = new PuntoVentaDTO();
        dto.setId(pv.getId());
        dto.setNombre(pv.getNombre());
        return dto;
    }

    public PuntoVenta fromDTO(PuntoVentaDTO dto) {
        return new PuntoVenta(dto.getId(), dto.getNombre());
    }
}
