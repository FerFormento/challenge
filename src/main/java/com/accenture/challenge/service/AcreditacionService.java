package com.accenture.challenge.service;

import java.util.List;

import com.accenture.challenge.dto.AcreditacionDto;
import com.accenture.challenge.entity.Acreditacion;

public interface AcreditacionService {

	Acreditacion cargarAcreditacion(AcreditacionDto acreditacionDto);
	
	Acreditacion consultaAcreditacion(Long id);

	List<Acreditacion> consultaTodasAcreditaciones();

}
