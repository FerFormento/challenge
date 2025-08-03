package com.accenture.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.challenge.entity.Acreditacion;

public interface AcreditacionRepository extends JpaRepository<Acreditacion, Long> { 

	/*
	 CREATE TABLE acreditacion (
	  id SERIAL PRIMARY KEY,
	  importe NUMERIC NOT NULL,
	  punto_venta VARCHAR(255) NOT NULL
		);
	 */
}
