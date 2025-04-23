package biblioteca;

import java.util.Map;
import java.util.Scanner;
import java.util.List;
//uso scanner para leer datos que ingresa el Usuario
public class Consola {
    public static final Scanner scanner = new Scanner(System.in);


    public Usuario seleccionarUsuario(List<Usuario> usuarios) {
        System.out.println("=== Seleccione un usuario para comenzar ===");
        for (Usuario u : usuarios) {
            System.out.println(u.getId() + " - " + u.getNombre() + " " + u.getApellido());
        }

        while (true) {
            System.out.print("Ingrese el ID del usuario: ");
            String input = scanner.nextLine();

            try {
                int id = Integer.parseInt(input);
                for (Usuario u : usuarios) {
                    if (u.getId() == id) return u;
                }
                System.out.println("ID no encontrado. Intente nuevamente.");
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    public void menuPrincipal(Usuario usuario, GestorBiblioteca gestor, ServicioPrestamos servicioPrestamos,
                              ServicioAlertas servicioAlertas, ServicioReportes servicioReportes, ServicioReserva servicioReserva) {
        mostrarAlertas(gestor);

        List<AlertaVencimiento> alertas = servicioAlertas.obtenerAlertasPendientes();
        alertas.forEach(AlertaVencimiento::mostrarAlerta);

        int opcion;
        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Gestión de Recursos");
            System.out.println("2. Gestión de Usuarios");
            System.out.println("3. Préstamos");
            System.out.println("4. Reservas");
            System.out.println("5. Reportes");
            System.out.println("6. Alertas");
            System.out.println("0. Salir");

            opcion = pedirOpcion();

            switch (opcion) {
                case 1: mostrarMenuGestionRecursos(gestor); break;
                case 2: mostrarMenuGestionUsuarios(gestor); break;
                case 3: mostrarMenuPrestamos(gestor, servicioPrestamos, usuario); break;
                case 4: mostrarReservasDesdeConsola(servicioReserva); break;
                case 5: mostrarMenuReportes(gestor, servicioReportes); break;
                case 6: mostrarAlertas(gestor); break;
                case 0: System.out.println("👋 ¡Hasta luego!"); break;
                default: System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }


    public int pedirOpcion() {
        System.out.print("Ingrese una opción: ");
        return scanner.nextInt();
    }

    public void mostrarMenuGestionRecursos(GestorBiblioteca gestor) {
        int opcion;
        do {
            System.out.println("=== Gestión de Recursos ===");
            System.out.println("1. Agregar recurso");
            System.out.println("2. Buscar recurso por título");
            System.out.println("3. Mostrar todos los recursos");
            System.out.println("0. Volver al menú principal");

            opcion = pedirOpcion();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    mostrarMenuAgregarRecurso(gestor); // 👈
                    break;
                case 2:
                    buscarRecursosPorTitulo(gestor);
                    break;
                case 3:
                    mostrarTodosLosRecursos(gestor);
                    break;
                case 0:
                    System.out.println("↩ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 0);
    }


    public void mostrarMenuGestionUsuarios(GestorBiblioteca gestor) {
        int opcion;
        do {
            System.out.println("=== Gestión de Usuarios ===");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Buscar usuario por ID");
            System.out.println("3. Mostrar todos los usuarios");
            System.out.println("0. Volver al menú principal");

            opcion = pedirOpcion();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrarUsuarioDesdeConsola(gestor);
                    break;
                case 2:
                    buscarUsuarioPorId(gestor);
                    break;
                case 3:
                    mostrarTodosLosUsuarios(gestor);
                    break;
                case 0:
                    System.out.println("↩ Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("❌ Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void mostrarMenuAgregarRecurso(GestorBiblioteca gestor) {
        System.out.println("=== Agregar Recurso ===");
        System.out.println("1. Libro");
        System.out.println("2. Revista");
        System.out.println("3. Audiolibro");
        System.out.println("4. Podcast");
        System.out.println("0. Cancelar");

        int tipo = pedirOpcion();
        scanner.nextLine();

        CreadorRecursos creador = new CreadorRecursos();

        switch (tipo) {
            case 1:
                Libro libro = creador.crearLibro();
                gestor.agregarRecurso(libro);
                break;
            case 2:
                Revista revista = creador.crearRevista();
                gestor.agregarRecurso(revista);
                break;
            case 3:
                AudioLibro audioLibro = creador.crearAudioLibro();
                gestor.agregarRecurso(audioLibro);
                break;
            case 4:
                Podcast podcast = creador.crearPodcast();
                gestor.agregarRecurso(podcast);
                break;
            case 0: return;
            default: System.out.println("❌ Tipo de recurso inválido.");
        }
    }


    public void mostrarMenuReportes(GestorBiblioteca gestor, ServicioReportes servicioReportes) {
        int opcion;
        do {
            System.out.println("=== Reportes en segundo plano ===");
            System.out.println("1. Recursos más prestados");
            System.out.println("2. Usuarios más activos");
            System.out.println("3. Estadísticas por categoría");
            System.out.println("0. Volver al menú principal");

            opcion = pedirOpcion();

            switch (opcion) {
                case 1:
                    servicioReportes.generarReporteEnSegundoPlano("recursos");
                    break;
                case 2:
                    servicioReportes.generarReporteEnSegundoPlano("usuarios");
                    break;
                case 3:
                    servicioReportes.generarReporteEnSegundoPlano("categorias");
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

            System.out.println();
        } while (opcion != 0);
    }

    public void mostrarMenuRecurso(RecursoDigitalBase recurso) {
        String tipo = recurso.getClass().getSimpleName();

        System.out.println("=== Menú del recurso seleccionado ===");
        System.out.println("1. Mostrar información " + tipo.toUpperCase());

        if (recurso instanceof Prestable) {
            System.out.println("2. Prestar " + tipo.toUpperCase());
            System.out.println("3. Devolver " + tipo.toUpperCase());
        }

        if (recurso instanceof Renovable) {
            System.out.println("4. Renovar " + tipo.toUpperCase());
        }

        System.out.println("0. Volver al menú principal");
    }

    public void mostrarMenuPrestamos(GestorBiblioteca gestor, ServicioPrestamos servicioPrestamos, Usuario usuario) {
        System.out.println("=== Menú de Préstamos ===");
        System.out.println("1. Realizar un préstamo");
        System.out.println("2. Devolver un recurso");
        System.out.println("3. Mostrar préstamos registrados");
        System.out.println("4. Mostrar préstamos de un usuario");
        System.out.println("0. Volver al menú principal");

        int opcion = pedirOpcion();

        switch (opcion) {
            case 1:
                realizarPrestamoDesdeConsola(gestor, servicioPrestamos);
                break;
            case 2:
                devolverRecursoDesdeConsola(gestor, servicioPrestamos, usuario);
                break;
            case 3:
                mostrarPrestamos(servicioPrestamos);
                break;
            case 4:
                mostrarPrestamosPorUsuario(servicioPrestamos, gestor);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción inválida.");
        }
    }


    public void mostrarMenuOrdenamiento(GestorBiblioteca biblioteca) {
        System.out.println("=== Búsqueda y Ordenamiento ===");
        System.out.println("1. Buscar por título");
        System.out.println("0. salir");

        int opcion = pedirOpcion();

        switch (opcion) {
            case 1:
                System.out.print("Ingrese título: ");
                String titulo = scanner.nextLine();
                List<RecursoDigital> encontrados = biblioteca.buscarPorTitulo(titulo);
                encontrados.forEach(RecursoDigital::mostrarInformacion);
                break;
            case 0:
                return;
            default:
                System.out.println("Opción inválida");
        }
    }

    public void mostrarCategoriasDisponibles() {
        System.out.println("=== Categorias Disponibles ===");
        for (CategoriaRecurso categoriaRecurso : CategoriaRecurso.values()) {
            System.out.println(categoriaRecurso.toString());
        }
    }

    public void buscarUsuarioPorId(GestorBiblioteca gestor) {
        while (true) {
            System.out.print("Ingrese ID del usuario: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                Usuario usuario = gestor.buscarUsuarioPorId(input);
                System.out.println("✅ Usuario encontrado:");
                System.out.println("Nombre: " + usuario.getNombre() + " " + usuario.getApellido());
                System.out.println("Email: " + usuario.getMail());
                break;
            } catch (UsuarioNoEncontradoException e) {
                System.out.println("⚠️ " + e.getMessage());
                System.out.println("Intente nuevamente o escriba 'salir'.");
            }
        }
    }

    public void buscarRecursosPorTitulo(GestorBiblioteca gestor) {
        scanner.nextLine(); // limpiar buffer si venís de un nextInt
        System.out.print("Ingrese el título del recurso a buscar: ");
        String titulo = scanner.nextLine().trim();

        List<RecursoDigital> resultados = gestor.buscarPorTitulo(titulo);

        if (resultados.isEmpty()) {
            System.out.println("❌ No se encontraron recursos con ese título.");
        } else {
            System.out.println("✅ Recursos encontrados:");
            for (RecursoDigital recurso : resultados) {
                recurso.mostrarInformacion();
            }
        }
    }

    public void mostrarTodosLosRecursos(GestorBiblioteca gestor) {
        List<RecursoDigital> recursos = gestor.getRecursos();

        if (recursos.isEmpty()) {
            System.out.println("📂 No hay recursos cargados.");
            return;
        }

        System.out.println("=== Recursos Disponibles por Tipo ===");

        mostrarGrupoRecurso("📚 LIBROS", recursos, Libro.class);
        mostrarGrupoRecurso("🗞️ REVISTAS", recursos, Revista.class);
        mostrarGrupoRecurso("🎧 AUDIOLIBROS", recursos, AudioLibro.class);
        mostrarGrupoRecurso("🎙️ PODCASTS", recursos, Podcast.class);
    }

    private void mostrarGrupoRecurso(String tituloGrupo, List<RecursoDigital> recursos, Class<?> tipo) {
        List<RecursoDigital> filtrados = recursos.stream()
                .filter(r -> tipo.isInstance(r))
                .toList();

        if (!filtrados.isEmpty()) {
            System.out.println("\n" + tituloGrupo);
            for (RecursoDigital r : filtrados) {
                r.mostrarInformacion();
            }
        }
    }


    public void prestarRecursos(RecursoDigitalBase recurso, Usuario usuario) {
        System.out.println("=== Prestar recursos ===");
        if (recurso instanceof Prestable) {
            try {
                ((Prestable) recurso).prestar(usuario);
                System.out.println("Prestamo exitoso");
            } catch (RecursoNoDisponibleException e) {
                System.out.println( e.getMessage());
            }
        } else {
            System.out.println("No se encontro el recurso");
        }
    }


    private void realizarPrestamoDesdeConsola(GestorBiblioteca gestor, ServicioPrestamos servicioPrestamos) {
        scanner.nextLine();
        System.out.print("Ingrese el título del recurso: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese ID del usuario: ");
        String id = scanner.nextLine();

        try {
            servicioPrestamos.agregarPrestamo(titulo, id);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getMessage());
        } catch (RecursoNoDisponibleException e) {
            System.out.println(e.getMessage());
        }
    }

    private void mostrarPrestamos(ServicioPrestamos servicioPrestamos) {
        servicioPrestamos.mostrarTodosLosPrestamos();
    }


    private void devolverRecursoDesdeConsola(GestorBiblioteca gestor, ServicioPrestamos servicioPrestamos, Usuario usuario) {
        scanner.nextLine(); // limpiar buffer
        System.out.print("Ingrese el título del recurso a devolver: ");
        String titulo = scanner.nextLine();

        List<RecursoDigital> recursos = gestor.buscarPorTitulo(titulo);

        if (recursos.isEmpty()) {
            System.out.println("Recurso no encontrado.");
            return;
        }

        RecursoDigital recurso = recursos.get(0);

        servicioPrestamos.devolver(recurso, usuario);
    }

    private void mostrarPrestamosPorUsuario(ServicioPrestamos servicioPrestamos, GestorBiblioteca gestor) {
        scanner.nextLine();
        System.out.print("Ingrese ID del usuario: ");
        String id = scanner.nextLine();

        try {
            Usuario usuario = gestor.buscarUsuarioPorId(id);
            servicioPrestamos.mostrarPrestamosPorUsuario(usuario);
        } catch (UsuarioNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public void mostrarAlertas(GestorBiblioteca gestor) {
        ServicioAlertas servicioAlertas = new ServicioAlertas(gestor);
        List<AlertaVencimiento> alertas = servicioAlertas.obtenerAlertasPendientes();

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ALERTAS POR VENCIMIENTO DE PRÉSTAMOS ===");
        if (alertas.isEmpty()) {
            System.out.println("No hay alertas por mostrar.");
        } else {
            for (AlertaVencimiento alerta : alertas) {
                alerta.mostrarAlerta();

                RecursoDigital recursoDigital = alerta.getPrestamo().getRecurso();
                Usuario usuario = alerta.getPrestamo().getUsuario();

                if (recursoDigital instanceof Renovable) {
                    System.out.print("¿Desea renovar este recurso? (si/no): ");
                    String respuesta = scanner.nextLine().trim().toLowerCase();

                    if (respuesta.equals("si")) {
                        ((Renovable) recursoDigital).renovar(usuario);
                    } else {
                        System.out.println("No se renovó.");
                    }
                } else {
                    System.out.println("Este recurso no es renovable.");
                }
            }
        }
    }


    public void mostrarReservasDesdeConsola(ServicioReserva servicioReserva) {
        servicioReserva.mostrarReservas();
    }

    private void registrarUsuarioDesdeConsola(GestorBiblioteca gestor) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("ID (número): ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Email: ");
        String mail = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Tipo de notificación (EMAIL o SMS): ");
        TipoNotificacion tipo = TipoNotificacion.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Nivel mínimo de urgencia para alertas (INFO, WARNING, ERROR): ");
        NivelUrgencia urgencia = NivelUrgencia.valueOf(scanner.nextLine().toUpperCase());

        Usuario nuevo = new Usuario(nombre, apellido, id, mail, telefono, tipo, urgencia);
        gestor.agregarUsuario(nuevo);
        System.out.println("✅ Usuario registrado exitosamente.");
    }


    private void mostrarTodosLosUsuarios(GestorBiblioteca gestor) {
        System.out.println("=== Usuarios Registrados ===");
        for (Map.Entry<String, Usuario> entry : gestor.getUsuarios().entrySet()) {
            Usuario u = entry.getValue();
            System.out.println("ID: " + u.getId() + " - " + u.getNombre() + " " + u.getApellido() +
                    " | Email: " + u.getMail() +
                    " | Notificación: " + u.getTipoNotificacion() +
                    " | Mín. urgencia: " + u.getNivelMinimoUrgencia());
        }
    }


}
