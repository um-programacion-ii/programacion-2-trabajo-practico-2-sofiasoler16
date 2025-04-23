[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/tc38IXJF)
# 📚 Trabajo Práctico: Sistema de Gestión de Biblioteca Digital (Java 21+)

## 📌 Objetivo General

Desarrollar un sistema de gestión de biblioteca digital que implemente los cinco principios SOLID, programación orientada a objetos, y conceptos avanzados de Java. El sistema deberá manejar diferentes tipos de recursos digitales, préstamos, reservas, y notificaciones en tiempo real.

### 👩‍🎓 Información del Alumno

**Nombre y Apellido:** Sofía Soler


## 📋 Requisitos Adicionales

### Documentación del Sistema
Como parte del trabajo práctico, deberás incluir en este README una guía de uso que explique:
---

## 🧠 ¿Cómo funciona el sistema?

### Descripción general de la arquitectura

Este sistema simula una **Biblioteca Digital** en consola. Los recursos como libros, revistas, audiolibros y podcasts pueden ser prestados, devueltos, reservados y renovados por usuarios registrados. El flujo de interacción se basa en un menú principal desde el cual el usuario puede navegar por todas las funcionalidades.

### Componentes principales

- `GestorBiblioteca`: maneja usuarios, recursos y préstamos.
- `ServicioPrestamos`, `ServicioReserva`, `ServicioAlertas`, `ServicioReportes`: encapsulan funcionalidades específicas.
- `RecursoDigital` y sus subclases (`Libro`, `Revista`, etc.): representan los distintos tipos de materiales.
- `Usuario`: representa a un lector con preferencia de notificación.
- `Consola`: maneja toda la interacción con el usuario desde el menú.
- `Main`: punto de entrada del sistema.

### Flujo de trabajo

1. El usuario elige su perfil al iniciar.
2. Navega por el menú para realizar acciones (agregar recursos, prestar, devolver, ver alertas, etc.).
3. Las acciones generan cambios en el sistema, notifican al usuario y desencadenan alertas y reservas si es necesario.
4. Los reportes y estadísticas se generan automáticamente en segundo plano.

---

## ⚙️ ¿Cómo ponerlo en funcionamiento?

### Requisitos previos

- Java 17 o superior.
- IDE (por ejemplo: IntelliJ IDEA) o terminal.
- Proyecto compilado con estructura estándar de paquetes.

### Compilación

Desde la terminal:
```bash
git clone https://github.com/sofiasoler16/programacion-2-trabajo-practico-2-sofiasoler16.git
```

Asegurate de estar ubicada en la raíz del proyecto (donde está la carpeta src):
```bash
javac src/biblioteca/*.java -d out
```

### Ejecución

```bash
java -cp out biblioteca.Main
```

Al ejecutarse:
- Mostrará los usuarios disponibles.
- Luego ingresás al menú principal.
- Al elegir 0. salir se ejecutan los ejemplos de funcionalidad.

---

## 🧪 ¿Cómo probar cada aspecto desarrollado?

Una vez empezado a correr el programa:

### 1. Gestión de Recursos

- **Agregar libro**: Opción 1 → Gestión de Recursos → Agregar Recurso → Libro
- **Buscar recurso**: Opción 1 → Buscar por título
- **Listar recursos**: Muestra los recursos agrupados por tipo

### 2. Gestión de Usuarios

- **Registrar usuario**: Opción 2 → Registrar
- **Buscar usuario**: Por ID (con validación y mensaje si no se encuentra)

### 3. Préstamos

- **Realizar préstamo**: Opción 3 → Realizar préstamo
- **Devolver recurso**: Opción 3 → Devolver
- **Visualizar préstamos**: Lista todos los préstamos o por usuario

### 4. Reservas

- Al intentar prestar un recurso **no disponible**, se ofrece hacer una reserva.
- Al devolver el recurso, si hay reservas, se muestra una **alerta de disponibilidad**.

### 5. Reportes

- Opción 5: permite generar:
  - Recursos más prestados
  - Usuarios más activos
  - Estadísticas por categoría
- Se ejecutan en **segundo plano**

### 6. Alertas

- Opción 6: muestra alertas por vencimiento.
- Si la alerta es de un recurso renovable, se ofrece renovarlo.
- Se respeta el nivel de urgencia configurado por el usuario (`INFO`, `WARNING`, `ERROR`).

---

## ✅ Ejemplos de prueba completos

### Flujo Completo de Préstamo

```java
    //EJEMPLO Flujo Completo de Prestamo
        // 1. Registrar un usuario
        Usuario usuario0 = new Usuario("Sofía", "Soler", 1, "sofia@mail.com", "2615551234", TipoNotificacion.EMAIL, NivelUrgencia.INFO);
        gestor.agregarUsuario(usuario0);
        System.out.println("✅ Usuario registrado: " + usuario0.getNombre());

        // 2. Agregar un libro
        Libro libro = new Libro("1984", 101, "Minotauro", "George Orwell", 1949, CategoriaRecurso.FICCION);
        gestor.agregarRecurso(libro);
        System.out.println("📚 Libro agregado: " + libro.getTitulo());

        // 3. Realizar el préstamo
        servicioPrestamos.prestar(libro, usuario0);

        // 4. Verificar estado del recurso
        System.out.println("📌 Estado actual del recurso: " + libro.getEstado());

        // 5. Devolver el recurso
        servicioPrestamos.devolver(libro, usuario0);

        // 6. Verificar estado del recurso
        System.out.println("📌 Estado después de la devolución: " + libro.getEstado());


```

### Sistema de Reservas

```java
   //EJEMPLO Sistema de Reservas:
        // 1. Registrar dos usuarios
        Usuario usuario1 = new Usuario("Sofi", "Soler", 1, "sofi@mail.com", "261555111", TipoNotificacion.EMAIL, NivelUrgencia.INFO);
        Usuario usuario2 = new Usuario("Juan", "Martínez", 2, "juan@mail.com", "261555222", TipoNotificacion.SMS, NivelUrgencia.WARNING);
        gestor.agregarUsuario(usuario1);
        gestor.agregarUsuario(usuario2);

        // 2. Agregar un libro
        Libro libro1 = new Libro("Clean Code", 100, "Prentice Hall", "Robert C. Martin", 2008, CategoriaRecurso.TECNOLOGIA);
        gestor.agregarRecurso(libro1);

        // 3. Usuario1 toma el préstamo exitosamente
        servicioPrestamos.prestar(libro1, usuario1);

        // 4. Usuario2 intenta prestarlo, pero como no está disponible se le pregunta si desea reservar
        servicioPrestamos.prestar(libro1, usuario2);


        // 5. Ver reservas
        System.out.println("\n--- Reservas pendientes ---");
        servicioReserva.mostrarReservas();

        // 6. Usuario1 devuelve el libro
        System.out.println("\n--- Usuario1 devuelve el libro ---");
        servicioPrestamos.devolver(libro1, usuario1);  // esto ya procesa reservas y presta al siguiente

        // 7. Verificamos que ya no hay reservas
        System.out.println("\n--- Reservas luego de la devolución ---");
        servicioReserva.mostrarReservas();

```

### Alertas y Notificaciones

```java
  // EJEMPLO: Alertas y Notificaciones:
        Usuario u1 = new Usuario("Sofía", "Soler", 1, "sofia@mail.com", "5492615882205", TipoNotificacion.EMAIL, NivelUrgencia.INFO);
        Usuario u2 = new Usuario("Juanito", "Martínez", 2, "juani@mail.com", "5492615999999", TipoNotificacion.SMS, NivelUrgencia.WARNING);
        gestor.agregarUsuario(u1);
        gestor.agregarUsuario(u2);

        Usuario usuario = new Usuario("Sofía", "Soler", 1, "sofia@mail.com", "5492615882205", TipoNotificacion.EMAIL, NivelUrgencia.INFO);
        gestor.agregarUsuario(usuario);

        Libro libro2 = new Libro("El Principito", 101, "Salamandra", "Antoine", 1943, CategoriaRecurso.FICCION);
        gestor.agregarRecurso(libro2);

        servicioPrestamos.prestar(libro2, usuario);

        Prestamo prestamo = new Prestamo(libro2, usuario);
        prestamo.setFechaDevolucion(LocalDate.now());  // ← Vence hoy
        gestor.agregarPrestamo(prestamo);

        // Mostrar alertas
        consola.mostrarAlertas(gestor);
```

## 🧩 Tecnologías y Herramientas

- Java 21+ (LTS)
- Git y GitHub
- GitHub Projects
- GitHub Issues
- GitHub Pull Requests

## 📘 Etapas del Trabajo

### Etapa 1: Diseño Base y Principios SOLID
- **SRP**: 
  - Crear clase `Usuario` con atributos básicos (nombre, ID, email)
  - Crear clase `RecursoDigital` como clase base abstracta
  - Implementar clase `GestorUsuarios` separada de `GestorRecursos`
  - Cada clase debe tener una única responsabilidad clara
  - Implementar clase `Consola` para manejar la interacción con el usuario

- **OCP**: 
  - Diseñar interfaz `RecursoDigital` con métodos comunes
  - Implementar clases concretas `Libro`, `Revista`, `Audiolibro`
  - Usar herencia para extender funcionalidad sin modificar código existente
  - Ejemplo: agregar nuevo tipo de recurso sin cambiar clases existentes
  - Implementar menú de consola extensible para nuevos tipos de recursos

- **LSP**: 
  - Asegurar que todas las subclases de `RecursoDigital` puedan usarse donde se espera `RecursoDigital`
  - Implementar métodos comunes en la clase base
  - Validar que el comportamiento sea consistente en todas las subclases
  - Crear métodos de visualización en consola para todos los tipos de recursos

- **ISP**: 
  - Crear interfaz `Prestable` para recursos que se pueden prestar
  - Crear interfaz `Renovable` para recursos que permiten renovación
  - Implementar solo las interfaces necesarias en cada clase
  - Diseñar menús de consola específicos para cada tipo de operación

- **DIP**: 
  - Crear interfaz `ServicioNotificaciones`
  - Implementar `ServicioNotificacionesEmail` y `ServicioNotificacionesSMS`
  - Usar inyección de dependencias en las clases que necesitan notificaciones
  - Implementar visualización de notificaciones en consola

### Etapa 2: Gestión de Recursos y Colecciones
- Implementar colecciones:
  - Usar `ArrayList<RecursoDigital>` para almacenar recursos
  - Usar `Map<String, Usuario>` para gestionar usuarios
  - Implementar métodos de búsqueda básicos
  - Crear menú de consola para gestión de recursos

- Crear servicios de búsqueda:
  - Implementar búsqueda por título usando Streams
  - Implementar filtrado por categoría
  - Crear comparadores personalizados para ordenamiento
  - Diseñar interfaz de consola para búsquedas con filtros

- Sistema de categorización:
  - Crear enum `CategoriaRecurso`
  - Implementar método de asignación de categorías
  - Crear búsqueda por categoría
  - Mostrar categorías disponibles en consola

- Manejo de excepciones:
  - Crear `RecursoNoDisponibleException`
  - Crear `UsuarioNoEncontradoException`
  - Implementar manejo adecuado de excepciones en los servicios
  - Mostrar mensajes de error amigables en consola

### Etapa 3: Sistema de Préstamos y Reservas
- Implementar sistema de préstamos:
  - Crear clase `Prestamo` con atributos básicos
  - Implementar lógica de préstamo y devolución
  - Manejar estados de los recursos (disponible, prestado, reservado)
  - Diseñar menú de consola para préstamos

- Sistema de reservas:
  - Crear clase `Reserva` con atributos necesarios
  - Implementar cola de reservas usando `BlockingQueue`
  - Manejar prioridad de reservas
  - Mostrar estado de reservas en consola

- Notificaciones:
  - Implementar sistema básico de notificaciones
  - Crear diferentes tipos de notificaciones
  - Usar `ExecutorService` para enviar notificaciones
  - Mostrar notificaciones en consola

- Concurrencia:
  - Implementar sincronización en operaciones de préstamo
  - Usar `synchronized` donde sea necesario
  - Manejar condiciones de carrera
  - Mostrar estado de operaciones concurrentes en consola

### Etapa 4: Reportes y Análisis
- Generar reportes básicos:
  - Implementar reporte de recursos más prestados
  - Crear reporte de usuarios más activos
  - Generar estadísticas de uso por categoría
  - Diseñar visualización de reportes en consola

- Sistema de alertas:
  - Implementar alertas por vencimiento de préstamos:
    - Crear clase `AlertaVencimiento` que monitorea fechas de devolución
    - Implementar lógica de recordatorios (1 día antes, día del vencimiento)
    - Mostrar alertas en consola con formato destacado
    - Permitir renovación desde la alerta
  
  - Crear notificaciones de disponibilidad:
    - Implementar `AlertaDisponibilidad` para recursos reservados
    - Notificar cuando un recurso reservado está disponible
    - Mostrar lista de recursos disponibles en consola
    - Permitir préstamo inmediato desde la notificación
  
  - Manejar recordatorios automáticos:
    - Implementar sistema de recordatorios periódicos
    - Crear diferentes niveles de urgencia (info, warning, error)
    - Mostrar historial de alertas en consola
    - Permitir configuración de preferencias de notificación

- Concurrencia en reportes:
  - Implementar generación de reportes en segundo plano
  - Usar `ExecutorService` para tareas asíncronas
  - Manejar concurrencia en acceso a datos
  - Mostrar progreso de generación de reportes en consola

## 📋 Detalle de Implementación

### 1. Estructura Base
```java
// Interfaces principales
public interface RecursoDigital {
    String getIdentificador();
    EstadoRecurso getEstado();
    void actualizarEstado(EstadoRecurso estado);
}

public interface Prestable {
    boolean estaDisponible();
    LocalDateTime getFechaDevolucion();
    void prestar(Usuario usuario);
}

public interface Notificable {
    void enviarNotificacion(String mensaje);
    List<Notificacion> getNotificacionesPendientes();
}

// Clase base abstracta
public abstract class RecursoBase implements RecursoDigital, Prestable {
    // Implementación común
}
```

### 2. Gestión de Biblioteca
```java
public class GestorBiblioteca {
    private final Map<String, RecursoDigital> recursos;
    private final List<Prestamo> prestamos;
    private final ExecutorService notificador;
    // Implementación de gestión
}
```

### 3. Sistema de Préstamos
```java
public class SistemaPrestamos {
    private final BlockingQueue<SolicitudPrestamo> colaSolicitudes;
    private final ExecutorService procesadorPrestamos;
    // Implementación de préstamos
}
```

## ✅ Entrega y Flujo de Trabajo con GitHub

1. **Configuración del Repositorio**
   - Proteger la rama `main`
   - Crear template de Issues y Pull Requests

2. **Project Kanban**
   - `To Do`
   - `In Progress`
   - `Code Review`
   - `Done`

3. **Milestones**
   - Etapa 1: Diseño Base
   - Etapa 2: Gestión de Recursos
   - Etapa 3: Sistema de Préstamos
   - Etapa 4: Reportes

4. **Issues y Pull Requests**
   - Crear Issues detallados para cada funcionalidad
   - Asociar cada Issue a un Milestone
   - Implementar en ramas feature
   - Revisar código antes de merge

## 📝 Ejemplo de Issue

### Título
Implementar sistema de préstamos concurrente

### Descripción
Crear el sistema de préstamos que utilice hilos y el patrón productor-consumidor para procesar solicitudes de préstamo en tiempo real.

#### Requisitos
- Implementar `BlockingQueue` para solicitudes de préstamo
- Crear procesador de solicitudes usando `ExecutorService`
- Implementar sistema de notificaciones
- Asegurar thread-safety en operaciones de préstamo

#### Criterios de Aceptación
- [ ] Sistema procesa préstamos concurrentemente
- [ ] Manejo adecuado de excepciones
- [ ] Documentación de diseño

### Labels
- `enhancement`
- `concurrency`

## ✅ Requisitos para la Entrega

- ✅ Implementación completa de todas las etapas
- ✅ Código bien documentado
- ✅ Todos los Issues cerrados
- ✅ Todos los Milestones completados
- ✅ Pull Requests revisados y aprobados
- ✅ Project actualizado

> ⏰ **Fecha de vencimiento**: 23/04/2025 a las 13:00 hs

## 📚 Recursos Adicionales

- Documentación oficial de Java 21
- Guías de estilo de código
- Ejemplos de implementación concurrente
- Patrones de diseño aplicados

## 📝 Consideraciones Éticas

### Uso de Inteligencia Artificial
El uso de herramientas de IA en este trabajo práctico debe seguir las siguientes pautas:

1. **Transparencia**
   - Documentar claramente qué partes del código fueron generadas con IA
   - Explicar las modificaciones realizadas al código generado
   - Mantener un registro de las herramientas utilizadas

2. **Aprendizaje**
   - La IA debe usarse como herramienta de aprendizaje, no como reemplazo
   - Comprender y ser capaz de explicar el código generado
   - Utilizar la IA para mejorar la comprensión de conceptos

3. **Integridad Académica**
   - El trabajo final debe reflejar tu aprendizaje y comprensión personal
   - No se permite la presentación de código generado sin comprensión
   - Debes poder explicar y defender cualquier parte del código

4. **Responsabilidad**
   - Verificar la corrección y seguridad del código generado
   - Asegurar que el código cumple con los requisitos del proyecto
   - Mantener la calidad y estándares de código establecidos

5. **Desarrollo Individual**
   - La IA puede usarse para facilitar tu proceso de aprendizaje
   - Documentar tu proceso de desarrollo y decisiones tomadas
   - Mantener un registro de tu progreso y aprendizaje

### Consecuencias del Uso Inadecuado
El uso inadecuado de IA puede resultar en:
- Calificación reducida o nula
- Sanciones académicas
- Pérdida de oportunidades de aprendizaje
- Impacto negativo en tu desarrollo profesional

## 📝 Licencia

Este trabajo es parte del curso de Programación Avanzada de Ingeniería en Informática. Uso educativo únicamente.
