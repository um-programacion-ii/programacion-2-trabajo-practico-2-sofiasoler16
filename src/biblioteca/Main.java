package biblioteca;

public class Main {
    public static void main(String[] args) {
        Podcast podcast = new Podcast("Vida de millonarios", 1, "LaCruda");

        System.out.println("Título: " + podcast.getTitulo());
        System.out.println("Canal: " + podcast.getCanal());


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
    }
}
