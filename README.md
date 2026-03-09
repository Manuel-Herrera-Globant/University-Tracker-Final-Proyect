# University Tracker

By : Manuel Herrera 

## Configuración inicial

- El proyecto usa **Maven**.
- El código fuente está en `src/main/java` dentro del paquete `com.university.tracker`.
- También se incluyo un `.gitignore` estándar para Java/IDE
- Y la estructura de carpetas para tests está lista (`src/test/java`).

## Flujo de trabajo y commits

La idea es trabajar en ramas separadas para cada feature y seguir el estilo **Conventional Commits**, ya que he trabajado con el en el pasado y lo elegi porque esto mantiene el historial legible y facilita revisiones.

Seria algo asi: 

1. Crear una rama nueva para cada cambio importante. Por ejemplo:
   ```bash
   git checkout -b feature/add-teacher-model
   ```
2. Los mensajes de commit irán con prefijos claros como:
   - `feat:` para nuevas funcionalidades 
   - `fix:` para correcciones 
   - `docs:` para documentación
   - `refactor:` cuando reestructure código
   - `chore:` para tareas de mantenimiento
3. Tras comprobar que la rama está lista, la integraré a `main` mediante pull request (en este caso solito no se puede pero es la practica adecuada).

### Nomenclatura de ramas

- `main` contendrá el código estable donde hare merge al tenerlo todo completo.
- Las ramas de trabajo usarán el prefijo `feature/`.




