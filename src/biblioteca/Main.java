package biblioteca;

public class Main {
    public static void main(String[] args) {

        Consola consola = new Consola();

        ServicioNotificaciones mail = new ServicioNotificacionesMail();
        ServicioNotificaciones sms = new ServicioNotificacionesSMS();

        consola.mostrarMenu();

        int opcion = 2;

        if (opcion == 2) {

            System.out.println("Se eligio la opcion: 2.Crear libro");

            Libro libro1 = new Libro("Orgullo y prejuicio", 1, "Salamandra", "Jane Austin", 2025, mail);

            libro1.prestar();
            
            System.out.println("Libro creado:");
            //Compruebo que sirva mostrarinformacion() de clase base
            libro1.mostrarInformacion();
        } else {
            System.out.println("Opción no implementada todavía.");
        }

        RecursoDigitalBase libro2 = new Libro("Java en Acción", 1, "Editorial Sofi", "Sofía Soler", 2024, sms);
        RecursoDigitalBase revista = new Revista("Ciencia Hoy", 2, 34, sms);
        RecursoDigitalBase audiolibro1 = new AudioLibro("Historias que Inspiran", 3, "2:45", sms);
        RecursoDigitalBase podcast = new Podcast("Charlas Sofi", 4, "Canal Sofía", sms);

        System.out.println("=== Probar comportamiento consistente (LSP) ===");
        libro2.mostrarInformacion();
        revista.mostrarInformacion();
        audiolibro1.mostrarInformacion();
        podcast.mostrarInformacion();


        consola.mostrarMenuRecurso(libro2);
        consola.mostrarMenuRecurso(audiolibro1);


    }
}
