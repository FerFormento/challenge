# challenge

# Microservicio Java con PostgreSQL y SonarQube usando Podman

Este proyecto es un microservicio Java (Spring Boot) que utiliza una base de datos **PostgreSQL** y administra puntos de venta y acreditaciones, todo ejecutado en contenedores usando **Podman**.

## 🛠️ Tecnologías
- Java 17
- Maven 3.8+
- Spring Boot
- PostgreSQL 15
- SonarQube latest
- Podman / Podman Desktop

## 📋 Requisitos previos
- Java 17 instalado (`java -version`)
- Maven instalado (`mvn -v`)
- Podman y podman-compose instalados
- Podman Desktop (opcional, para interfaz gráfica)

## Como probar endpoints
- Se encuentran 3 collections de postamn en la carpeta docs/collection-postman. En cada collection se encuentra un request para probar cada endpoint de cada controller.

## Diagrama de clases
- Se encuentra un archivo mermaid en la carpeta docs/diagramas

## Cobertura del codigo con Sonar
- Se encuentra una imagen en la carpeta docs/sonar donde se ve que tiene un 81% de cobertura.
Esto se hizo levantando un container con sonar en podman y evaluando los tests que tiene el microservicio.

## 🏗️ Arquitectura
```mermaid
graph LR
A[Microservicio Java] -->|JDBC| B[(PostgreSQL)]

