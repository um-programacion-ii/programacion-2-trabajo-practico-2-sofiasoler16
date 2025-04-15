package biblioteca;

public class Main {
    public static void main(String[] args) {

        Consola consola = new Consola();

        consola.mostrarMenu();

        int opcion = 2;

        if (opcion == 2) {

            System.out.println("Se eligio la opcion: 2.Crear libro");

            Libro libro = new Libro("Orgullo y prejuicio", 1, "Salamandra", "Jane Austin", 2025);

            System.out.println("Libro creado:");
            //Compruebo que sirva mostrarinformacion() de clase base
            libro.mostrarInformacion();
        } else {
            System.out.println("Opción no implementada todavía.");
        }

        RecursoDigitalBase libro = new Libro("Java en Acción", 1, "Editorial Sofi", "Sofía Soler", 2024);
        RecursoDigitalBase revista = new Revista("Ciencia Hoy", 2, 34);
        RecursoDigitalBase audiolibro = new AudioLibro("Historias que Inspiran", 3, "2:45");
        RecursoDigitalBase podcast = new Podcast("Charlas Sofi", 4, "Canal Sofía");

        System.out.println("=== Probar comportamiento consistente (LSP) ===");
        libro.mostrarInformacion();
        revista.mostrarInformacion();
        audiolibro.mostrarInformacion();
        podcast.mostrarInformacion();

    }
}
