package biblioteca;

import java.util.List;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Consola consola = new Consola();


        CategoriaRecurso tecnologia = CategoriaRecurso.TECNOLOGIA;
        CategoriaRecurso novela = CategoriaRecurso.NOVELA;
        CategoriaRecurso historia = CategoriaRecurso.HISTORIA;
        CategoriaRecurso romance = CategoriaRecurso.ROMANCE;
        CategoriaRecurso ciencia = CategoriaRecurso.CIENCIA;
        CategoriaRecurso interes = CategoriaRecurso.INTERES;
        CategoriaRecurso ficcion = CategoriaRecurso.FICCION;

        consola.mostrarMenu();

        Usuario usuario1 = new Usuario("Sofía", "Soler", 1, "sofia@mail.com", "5492615882205", TipoNotificacion.EMAIL, NivelUrgencia.INFO );
        int opcion = 2;

        if (opcion == 2) {

            System.out.println("Se eligio la opcion: 2.Crear libro");

            Libro libro1 = new Libro("Orgullo y prejuicio", 1, "Salamandra", "Jane Austin", 2025, CategoriaRecurso.ROMANCE);

            libro1.prestar(usuario1);
            
            System.out.println("Libro creado:");
            //Compruebo que sirva mostrarinformacion() de clase base
            libro1.mostrarInformacion();
        } else {
            System.out.println("Opción no implementada todavía.");
        }

        RecursoDigitalBase libro2 = new Libro("Java en Acción", 1, "Editorial Sofi", "Sofía Soler", 2025, CategoriaRecurso.TECNOLOGIA);
        RecursoDigitalBase revista = new Revista("Ciencia Hoy", 2, 34, CategoriaRecurso.CIENCIA);
        RecursoDigitalBase audiolibro1 = new AudioLibro("Historias que Inspiran", 3, "2:45", CategoriaRecurso.HISTORIA);
        RecursoDigitalBase podcast = new Podcast("Charlas Sofi", 4, "Canal Sofía", CategoriaRecurso.INTERES);

        System.out.println("=== Probar comportamiento consistente (LSP) ===");
        libro2.mostrarInformacion();
        revista.mostrarInformacion();
        audiolibro1.mostrarInformacion();
        podcast.mostrarInformacion();


        consola.mostrarMenuRecurso(libro2);
        consola.mostrarMenuRecurso(audiolibro1);


        System.out.println("---Pruebas Gestor Biblioteca---");

        GestorBiblioteca gestorBiblioteca = new GestorBiblioteca();

        ServicioReserva servicioReserva = new ServicioReserva();
        ServicioPrestamos servicioPrestamos = new ServicioPrestamos(gestorBiblioteca, servicioReserva);


        gestorBiblioteca.agregarUsuario(usuario1);

        Libro libro3  = new Libro("El Principito", 101, "Editorial Salamandra", "Antoine", 1943, CategoriaRecurso.FICCION);
        gestorBiblioteca.agregarRecurso(libro2);
        gestorBiblioteca.agregarRecurso(libro3);
        gestorBiblioteca.agregarRecurso(revista);
        gestorBiblioteca.agregarRecurso(audiolibro1);
        gestorBiblioteca.agregarRecurso(podcast);


        RecursoDigital encontrado = gestorBiblioteca.buscarRecursoPorTitulo("Java en Acción");
        RecursoDigital encontradoRev = gestorBiblioteca.buscarRecursoPorTitulo("Ciencia Hoy");

        //Le digo que muestre la informacion si lo encuentra (DEL LIBRO)
        if(encontrado != null){
            encontrado.mostrarInformacion();
        }

        //muestra la informacion (DE LA REVISTA)
        encontradoRev.mostrarInformacion();


        List<RecursoDigital> resultados = gestorBiblioteca.buscarPorTitulo("java");
        System.out.println("=== Resultados de búsqueda por título ===");
        for (RecursoDigital recurso : resultados) {
            recurso.mostrarInformacion();
        }

        consola.mostrarCategoriasDisponibles();

        List<RecursoDigital> filtroCategoria = gestorBiblioteca.filtrarPorCategoria(ficcion);

        System.out.println("=== Recursos en categoría: " + ficcion + " ===");
        for (RecursoDigital r : filtroCategoria) {
            r.mostrarInformacion();
        }

        consola.mostrarMenuOrdenamiento(gestorBiblioteca);

        System.out.println("---Pruebas Buscar Usuarios (Con try-catch)---");

        consola.buscarUsuarioPorId(gestorBiblioteca);

        ((Prestable) podcast).prestar(usuario1); // presto el podcast

        consola.prestarRecursos(podcast, usuario1);

        System.out.println("---Pruebas servicioPrestamo---");

        servicioPrestamos.prestar(libro2, usuario1);
        // servicioPrestamos.devolver(libro2);


        consola.mostrarMenuPrestamos(gestorBiblioteca, servicioPrestamos, usuario1);

        System.out.println("---Pruebas servicioReserva---");


        Reserva reserva1 = new Reserva(usuario1, podcast);

        servicioReserva.agregarReserva(reserva1);

        // consola.mostrarReservasDesdeConsola(servicioReserva);

        servicioReserva.mostrarReservas();

        System.out.println("---Pruebas Notificaciones---");

        Notificaciones noti1 = new NotificacionesMail("Tu libro fue prestado con éxito", usuario1.getMail());
        Notificaciones noti2 = new NotificacionesSMS("Recordatorio de devolución", usuario1.getTelefono());
        noti1.enviar();
        noti2.enviar();


//        System.out.println("---Pruebas Concurrencia---");
//
//        AudioLibro audioLibroTest = new AudioLibro("Audiolibro Concurrencia", 999, "1h", sms, CategoriaRecurso.CIENCIA);
//
//        Usuario usuarioA = new Usuario("UsuarioA", "Perez", 101, "a@correo.com", "123456789");
//        Usuario usuarioB = new Usuario("UsuarioB", "Gomez", 102, "b@correo.com", "987654321");
//
//        Thread hilo1 = new Thread(() -> {
//            audioLibroTest.prestar(usuarioA);
//        }, "Hilo-A");
//
//        Thread hilo2 = new Thread(() -> {
//            try {
//                audioLibroTest.prestar(usuarioB);
//            } catch (RecursoNoDisponibleException e) {
//                System.out.println("[HILO Hilo-B] " + e.getMessage());
//            }
//        }, "Hilo-B");
//
//
//        hilo1.start();
//        hilo2.start();
//
//        try {
//            hilo1.join();
//            hilo2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        System.out.println("---Prueba menu reportes---");
//
//        ServicioReportes servicioReportes = new ServicioReportes(gestorBiblioteca);
//
//        consola.mostrarMenuReportes(gestorBiblioteca, servicioReportes);
//

        ((Prestable) libro3).prestar(usuario1);
        Prestamo prestamo = new Prestamo(libro3, usuario1);
        prestamo.setFechaDevolucion(LocalDate.now());
        gestorBiblioteca.agregarPrestamo(prestamo);


        ServicioAlertas servicioAlertas = new ServicioAlertas(gestorBiblioteca);
        consola.mostrarAlertas(gestorBiblioteca);

        HistorialAlertas historialAlertas = new HistorialAlertas();

        Recordatorios recordatorios = new Recordatorios(servicioAlertas, historialAlertas);
        recordatorios.iniciar();

        servicioPrestamos.prestar(libro2, usuario1);

        Usuario usuario2 = new Usuario("Juanito", "Martínez", 2, "juani@mail.com", "5492615999999", TipoNotificacion.SMS, NivelUrgencia.WARNING);
        gestorBiblioteca.agregarUsuario(usuario2);

        Reserva reserva2 = new Reserva(usuario2, libro2);
        servicioReserva.agregarReserva(reserva2);

        servicioReserva.mostrarReservas();

        servicioPrestamos.devolver(libro2, usuario1);

        recordatorios.iniciar();

        historialAlertas.mostrarHistorial();



    }

}
