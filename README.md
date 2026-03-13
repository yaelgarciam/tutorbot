# TutorBot

Interfaz y API simple en Spring Boot para gestionar estudiantes y ejercicios.

## Requisitos
- Java 21
- Maven (usa `./mvnw` incluido)

## Ejecutar la aplicación
```bash
mvn spring-boot:run
```
La app se levanta en `http://localhost:8080`.

## UI web
Hay una página estática en `src/main/resources/static/index.html`.
Al correr la app, abre en el navegador: `http://localhost:8080/index.html`.

Desde la UI puedes:
- Listar estudiantes (`GET /api/students`) o consultar uno por id.
- Registrar un estudiante (`POST /api/students`).
- Listar ejercicios y filtrar por dificultad (`GET /api/exercises?difficulty=easy|medium|hard`).
- Enviar respuesta para calificar (`POST /api/exercises/submit`).

## Endpoints (JSON)
- `GET /api/students`
- `GET /api/students/{id}`
- `POST /api/students` body: `{ "name": "", "age": 20, "level": "beginner|intermediate/advanced" }` (el backend genera `id` y `email` en formato `A0{id}@tec.mx`)
- `GET /api/exercises?difficulty=...`
- `POST /api/exercises/submit` body: `{ "studentId": 1, "exerciseId": 1, "answer": "texto" }`

## Tests
```bash
./mvnw test
```

## Notas
- Los datos se guardan en memoria (listas en repositorios); se pierden al reiniciar.
- Para cambiar ejercicios o estudiantes iniciales, edita los repositorios en `src/main/java/com/tutorbot/repository/`.
