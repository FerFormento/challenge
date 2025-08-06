package com.accenture.challenge.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.accenture.challenge.dto.PuntoVentaDto;
import com.accenture.challenge.service.PuntoVentaService;

@WebMvcTest(PuntoVentaController.class)
public class PuntoVentaControllerTest {

 @Autowired
 private MockMvc mockMvc;

 @MockBean
 private PuntoVentaService service;

 @Test
 public void testGetAll() throws Exception {
     List<PuntoVentaDto> mockList = List.of(new PuntoVentaDto(1, "CABA"));
     when(service.getAll()).thenReturn(mockList);

     mockMvc.perform(get("/puntos-venta"))
             .andExpect(status().isOk());
 }

 @Test
 public void testAdd() throws Exception {
     PuntoVentaDto pv = new PuntoVentaDto(20, "Tucumán");
     when(service.add(any())).thenReturn(pv);

     mockMvc.perform(post("/puntos-venta")
             .contentType(MediaType.APPLICATION_JSON)
             .content("{\"id\":20,\"nombre\":\"Tucumán\"}"))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.nombre").value("Tucumán"));
 }

 @Test
 public void testDelete() throws Exception {
     PuntoVentaDto pv = new PuntoVentaDto(1, "CABA");
     when(service.delete(1)).thenReturn(pv);

     mockMvc.perform(delete("/puntos-venta/1"))
             .andExpect(status().isOk())
             .andExpect(jsonPath("$.nombre").value("CABA"));
 }
}

