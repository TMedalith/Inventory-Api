# Kaeser Platform RESTful API

Este repositorio contiene el código fuente del RESTful API desarrollado para brindar soporte a las operaciones de Kaeser Platform, una plataforma que permite la gestión y monitoreo de equipos de aire comprimido.

## Descripción

El API proporciona endpoints para manejar la información de Equipments y Spare Parts.

## Tecnologías Utilizadas

- Java
- Spring Boot Framework
- Spring Data JPA
- Project Lombok
- Springdoc-openapi

## Estructura del Proyecto

El proyecto está organizado siguiendo las convenciones de Java, Spring Boot Framework y Domain-Driven Design. A continuación, se detalla la estructura principal del proyecto:

- **src/main/java**: Contiene el código fuente de la aplicación.
  - **com.kaeser.platform**: Paquete principal de la aplicación.
    - **config**: Contiene la configuración de la aplicación.
    - **controller**: Controladores REST para los endpoints.
    - **model**: Modelos de datos y entidades JPA.
    - **repository**: Repositorios JPA para el acceso a datos.
    - **service**: Servicios que implementan la lógica de negocio.
- **src/test/java**: Contiene las pruebas unitarias y de integración.

## API Endpoints

### Equipments

- **Create Equipment**: `POST /api/v1/equipments`

    Endpoint for creating new equipment. Requires a JSON payload containing the equipment model and type.

- **Get Equipment by ID**: `GET /api/v1/equipments/{equipmentId}`

    Endpoint for retrieving equipment by its ID.

### Spare Parts

- **Add Spare Part to Equipment**: `POST /api/v1/equipments/{equipmentId}/spare-parts`

    Endpoint for adding spare parts to existing equipment. Requires a JSON payload containing information about the spare part.

## Requisitos

- Java JDK 8 o superior
- Maven
- IDE compatible con Spring Boot (por ejemplo, IntelliJ IDEA, Eclipse)

