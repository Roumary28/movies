# Movie API REST 🎬

Esta API REST es una solución desarrollada en Spring Boot para gestionar un catálogo de películas. Incluye operaciones CRUD completas y un sistema de votación para calificar películas, ideal para aplicaciones de entretenimiento, catálogos de películas y sistemas de recomendación.

## Características Principales

- CRUD completo para la gestión de películas
- Endpoint para votar y actualizar la calificación de cada película
- Implementación en **Spring Boot** con **MySQL** como base de datos
- Configuración de CORS para facilitar el acceso cross-origin

## Requisitos

- **Java 17**
- **Maven**
- **MySQL** (o cualquier base de datos compatible con JPA)

## Instalación

1. Clona este repositorio:

git clone https://github.com/tu-usuario/movie-api-rest.git
cd movie-api-rest

2. Configura la base de datos en el archivo application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/movie_db

spring.datasource.username=tu_usuario

spring.datasource.password=tu_contraseña

spring.jpa.hibernate.ddl-auto=update

3. Ejecuta la aplicacion 

mvn spring-boot:run

4. La API estará disponible en http://localhost:8080/api/movies.

## Estructura de la Base de Datos

La tabla `Movies` contiene las siguientes columnas:

| Campo    | Tipo         | Descripción                                   |
|----------|--------------|-----------------------------------------------|
| `id`     | `BIGINT`     | Identificador único de la película.           |
| `titulo` | `VARCHAR`    | Título de la película.                        |
| `año`    | `INT`        | Año de estreno de la película.                |
| `votos`  | `INT`        | Cantidad de votos recibidos.                  |
| `rating` | `DOUBLE`     | Puntuación promedio de la película.           |
| `imagen_url` | `VARCHAR` | URL de la imagen de portada de la película.   |

## Endpoints

### Obtener todas las películas

- **URL**: `/api/movies`
- **Método HTTP**: `GET`
- **Descripción**: Devuelve una lista con todas las películas.
- **Ejemplo de respuesta**:

  ```json
  [
      {
          "id": 1,
          "titulo": "Inception",
          "año": 2010,
          "votos": 1200,
          "rating": 8.8,
          "imagen_url": "https://example.com/inception.jpg"
      },
     
  ]

 ### Obteter una pelicula por ID

 - **URL**: `/api/movies/{id}`
- **Método HTTP**: `GET`
- **Descripción**: Devuelve la informacion de una pelicula especifica 
- **Respuesta en caso de exito**: 200 OK 
- **Respuesta en caso de error**: 404 Not Found 

### Crear una pelicula

 - **URL**: `/api/movies`
- **Método HTTP**: `POST`
- **Descripción**: Crea una pelicula
- **Cuerpo de la solicitud**:  

  ```json
  [
     {
    "titulo": "New Movie",
    "año": 2023,
    "votos": 0,
    "rating": 0.0,
    "imagen_url": "https://example.com/new_movie.jpg"
    },

      
  ]
- **Respuesta en caso de exito**: 201 Created  

### Actualizar una pelicula

 - **URL**: `/api/movies/{id}`
- **Método HTTP**: `PUT`
- **Descripción**: Actualiza la informacion de una pelicula existente
- **Cuerpo de la solicitud**:  

  ```json
  [
    {
    "titulo": "Updated Movie",
    "año": 2023,
    "votos": 100,
    "rating": 7.5,
    "imagen_url": "https://example.com/updated_movie.jpg"
    }

  ]
- **Respuesta en caso de exito**: 200 OK  
- **Respuesta en caso de error**: 404 Not Found 

 ### Eliminar una pelicula

 - **URL**: `/api/movies/{id}`
- **Método HTTP**: `DELETE`
- **Descripción**: Elimina una pelicula de la base de datos
- **Respuesta en caso de exito**: 204 No COntent 
- **Respuesta en caso de error**: 404 Not Found 

### Votar una pelicula

 - **URL**: `/api/movies/{id}/{rating}`
- **Método HTTP**: `GET`
- **Descripción**: Permite votar una pelicula especifica, actualizando el numero total de votos y el rating promedio.
- **Respuesta en caso de exito**: 200 OK
- **Respuesta en caso de error**: 404 Not Found 



