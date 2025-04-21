package biblioteca;

import java.util.Map;
import java.util.stream.Collectors;

public class ServicioReportes {

    private final GestorBiblioteca gestor;

    //Constructor
    public ServicioReportes(GestorBiblioteca gestor) {
        this.gestor = gestor;
    }

    public void reporteRecursosMasPrestados(int limite) {
        System.out.println("===Recursos mas prestados===");

        Map<RecursoDigital, Long> conteo = gestor.getPrestamos().stream()
                .collect(Collectors.groupingBy(Prestamo::getRecurso, Collectors.counting()));

        conteo.entrySet().stream()
                .sorted(Map.Entry.<RecursoDigital, Long>comparingByValue().reversed())
                .limit(limite)
                .forEach(entry -> System.out.println(entry.getKey().getIdentificador() + " - Préstamos: " + entry.getValue()));
    }

}
