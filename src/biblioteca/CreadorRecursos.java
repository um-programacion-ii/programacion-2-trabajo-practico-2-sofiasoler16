package biblioteca;

import java.util.Scanner;

public class CreadorRecursos {
    private final Scanner scanner;

    public CreadorRecursos() {
        this.scanner = new Scanner(System.in);
    }

    public Libro crearLibro() {
        System.out.println("=== Crear Libro ===");
        String titulo = pedir("Título");
        int id = Integer.parseInt(pedir("ID"));
        String editorial = pedir("Editorial");
        String autor = pedir("Autor");
        int ano = Integer.parseInt(pedir("Año de publicación"));
        CategoriaRecurso categoria = pedirCategoria();

        return new Libro(titulo, id, editorial, autor, ano, categoria);
    }

    public AudioLibro crearAudioLibro() {
        System.out.println("=== Crear AudioLibro ===");
        String titulo = pedir("Título");
        int id = Integer.parseInt(pedir("ID"));
        String tiempo = pedir("Duración (ej: 2:45)");
        CategoriaRecurso categoria = pedirCategoria();

        return new AudioLibro(titulo, id, tiempo, categoria);
    }

    public Revista crearRevista() {
        System.out.println("=== Crear Revista ===");
        String titulo = pedir("Título");
        int id = Integer.parseInt(pedir("ID"));
        int numeroEdicion = Integer.parseInt(pedir("Número de edición"));
        CategoriaRecurso categoria = pedirCategoria();

        return new Revista(titulo, id, numeroEdicion, categoria);
    }

    public Podcast crearPodcast() {
        System.out.println("=== Crear Podcast ===");
        String titulo = pedir("Título");
        int id = Integer.parseInt(pedir("ID"));
        String canal = pedir("Canal");
        CategoriaRecurso categoria = pedirCategoria();

        return new Podcast(titulo, id, canal, categoria);
    }

    private String pedir(String campo) {
        System.out.print(campo + ": ");
        return scanner.nextLine();
    }

    private CategoriaRecurso pedirCategoria() {
        System.out.println("Categorías disponibles:");
        for (CategoriaRecurso cat : CategoriaRecurso.values()) {
            System.out.println("- " + cat);
        }
        String entrada = pedir("Ingrese una categoría").toUpperCase();
        return CategoriaRecurso.valueOf(entrada);
    }
}
