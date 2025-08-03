package com.accenture.challenge.exception;

public class AcreditacionNoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = -280485875531943362L;

	public AcreditacionNoEncontradaException(Long id) {
        super("Acreditación con id " + id + " no encontrada");
    }
}