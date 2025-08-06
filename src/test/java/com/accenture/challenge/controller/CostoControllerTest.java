package com.accenture.challenge.controller;

import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.MockMvc;

import com.accenture.challenge.constant.MetodoBusquedaEnum;
import com.accenture.challenge.dto.ResultadoMejorCaminoDto;
import com.accenture.challenge.dto.PuntoVentaDto;
import com.accenture.challenge.service.CostoService;
import com.accenture.challenge.service.PuntoVentaService;

@WebMvcTest(CostoController.class)
public class CostoControllerTest {

 @Autowired
 private MockMvc mockMvc;

 @MockBean
 private CostoService costoService;

 @MockBean
 private PuntoVentaService pvService;

 @Test
 public void testVecinos() throws Exception {
     when(costoService.vecinos(1)).thenReturn(Map.of(2, 5));
     when(pvService.get(2)).thenReturn(new PuntoVentaDto(2, "GBA_1"));

     mockMvc.perform(get("/costos/vecinos/1"))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.GBA_1").value(5));
 }

 @Test
 public void testCaminoMinimo() throws Exception {
     when(costoService.buscarMejorCamino(1, 4, MetodoBusquedaEnum.DIJKSTRA)).thenReturn(
         new ResultadoMejorCaminoDto(10, List.of(1, 2, 4))
     );
     when(pvService.get(1)).thenReturn(new PuntoVentaDto(1, "CABA"));
     when(pvService.get(2)).thenReturn(new PuntoVentaDto(2, "GBA_1"));
     when(pvService.get(4)).thenReturn(new PuntoVentaDto(4, "Santa Fe"));

     mockMvc.perform(get("/costos/camino-minimo?origen=1&destino=4&metodo=DIJKSTRA"))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.costo").value(10))
             .andExpect(jsonPath("$.camino[0]").value("CABA"))
             .andExpect(jsonPath("$.camino[2]").value("Santa Fe"));
 }
}

