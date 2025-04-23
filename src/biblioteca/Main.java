package biblioteca;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Consola consola = new Consola();

        // Crear gestor y servicios
        GestorBiblioteca gestor = new GestorBiblioteca();
        ServicioReserva servicioReserva = new ServicioReserva();
        ServicioPrestamos servicioPrestamos = new ServicioPrestamos(gestor, servicioReserva);
        ServicioAlertas servicioAlertas = new ServicioAlertas(gestor);
        ServicioReportes servicioReportes = new ServicioReportes(gestor);

        // Agregar algunos usuarios para que se puedan seleccionar
        Usuario u3 = new Usuario("Sofía", "Soler", 1, "sofia@mail.com", "2615551234", TipoNotificacion.EMAIL, NivelUrgencia.INFO);
        Usuario u4 = new Usuario("Juan", "Pérez", 2, "juan@mail.com", "2615555678", TipoNotificacion.SMS, NivelUrgencia.WARNING);
        gestor.agregarUsuario(u3);
        gestor.agregarUsuario(u4);

        // Seleccionar usuario
        Usuario usuarioActual = consola.seleccionarUsuario(gestor.getUsuarios().values().stream().toList());

        // Lanzar menú principal con el usuario seleccionado
        consola.menuPrincipal(usuarioActual, gestor, servicioPrestamos, servicioAlertas, servicioReportes, servicioReserva);
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

    }
}

