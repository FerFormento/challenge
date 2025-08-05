# challenge

# Microservicio Java con PostgreSQL y SonarQube usando Podman

Este proyecto es un microservicio Java (Spring Boot) que utiliza una base de datos **PostgreSQL** y administra puntos de venta y acreditaciones, todo ejecutado en contenedores usando **Podman**.
La idea que plantee para la resolucion de como obtener el camino mas corto entre dos puntos de venta. Fue utilizar el patron Strategy implementando dos tipos de resolucion distintos. Uno es con A* y el otro es con Dijkstra. Por lo tanto, al momento de utilizar le endpoint "/costos/camino-minimo?origen=1&destino=5&metodo=A_STAR" se le debe indicar que metodo se quiere utilizar usando los siguientes String "A_STAR" y "DIJKSTRA".

Con respecto a la utilizacion de las nueva utilidades de java hasta la version 17. Se han utilizado "var" en los tests y "record" en los DTO para que el codigo sea mas legible. Tambien en java 17 se mejoro el soporte de uso de memoria y CPU dentro de contenedores que viene bien porque en este caso se utilizan con Podman.



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
- Podman Desktop (para interfaz gráfica)

## Levantar containers en podman
- En el raiz del proyecto se encuentran un Dockerfile para poder generar un docker image.
- Ademas, en el raiz del proyecto se encuentra un podman-compose.yml para levantar un container con una base de datos Postgres y otro container con el proyecto.

## Como probar endpoints
- Se encuentran 3 collections de postamn en la carpeta docs/collection-postman. En cada collection se encuentra un request para probar cada endpoint de cada controller.

## 📘 API Documentation
La documentación de la API está disponible mediante Swagger UI.

### 🔗 Acceso al Swagger
Una vez que el microservicio está corriendo, podés acceder a la documentación desde:
http://localhost:8080/swagger-ui.html


## Diagrama de clases
- Se encuentra un archivo mermaid en la carpeta docs/diagramas.

## Cobertura del codigo con Sonar
- Se encuentra una imagen en la carpeta docs/sonar donde se ve que tiene un 81% de cobertura.
Esto se hizo levantando un container con sonar en podman y evaluando los tests que tiene el microservicio.

## 🏗️ Arquitectura
```mermaid
graph LR
A[Microservicio Java] -->|JDBC| B[(PostgreSQL)]

