package com.accenture.challenge.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.accenture.challenge.dto.PuntoVenta;
import com.accenture.challenge.service.impl.PuntoVentaServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PuntoVentaServiceTest {

 private PuntoVentaService service;

 @BeforeEach
 public void setUp() {
     service = new PuntoVentaServiceImpl();
     service.init(); // cargar los datos iniciales
 }

 @Test
 public void testGetAll() {
     List<PuntoVenta> puntos = service.getAll();
     assertEquals(10, puntos.size());
 }

 @Test
 public void testAddAndGet() {
     PuntoVenta pv = new PuntoVenta(20, "Neuquén");
     service.add(pv);
     assertEquals(pv, service.get(20));
 }

 @Test
 public void testUpdate() {
     PuntoVenta updated = new PuntoVenta(1, "Buenos Aires");
     service.update(updated);
     assertEquals("Buenos Aires", service.get(1).nombre());
 }

 @Test
 public void testDelete() {
     service.delete(2);
     assertNull(service.get(2));
 }
}

