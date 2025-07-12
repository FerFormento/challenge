package com.accenture.challenge.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MultiplicadorController {

    @PostMapping("/multiplicar")
    public Resultado multiplicar(@RequestBody Numero numero) {
        int resultado = numero.getValor() * 2;
        return new Resultado(resultado);
    }

    public static class Numero {
        private int valor;

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }
    }

    public static class Resultado {
        private int resultado;

        public Resultado(int resultado) {
            this.resultado = resultado;
        }

        public int getResultado() {
            return resultado;
        }

        public void setResultado(int resultado) {
            this.resultado = resultado;
        }
    }
}