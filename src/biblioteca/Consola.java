package biblioteca;

import java.util.Scanner;
import java.util.List;
//uso scanner para leer datos que ingresa el Usuario
public class Consola {
    private Scanner scanner;

    public Consola() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("===Biblioteca===");
        System.out.println("1. Crear usuarios");
        System.out.println("2. Crear libro");
        System.out.println("3. Crear revista");
        System.out.println("4. Crear audiolibro");
        System.out.println("5. Crear podcast");
        System.out.println("6. Salir");
    }
    public int pedirOpcion() {
        System.out.print("Ingrese una opción: ");
        return scanner.nextInt();
    }

    public void mostrarMenuGestionRecursos() {
        System.out.println("=== Gestión de Recursos ===");
        System.out.println("1. Agregar recurso");
        System.out.println("2. Buscar recurso por título");
        System.out.println("3. Mostrar todos los recursos");
        System.out.println("0. Volver al menú principal");
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
                break; // salimos del bucle si se encontró
            } catch (UsuarioNoEncontradoException e) {
                System.out.println("⚠️ " + e.getMessage());
                System.out.println("Intente nuevamente o escriba 'salir'.");
            }
        }
    }


}
