package biblioteca;

import java.time.LocalDate;

public class AlertaVencimiento {
    private Prestamo prestamo;
    private String tipoAlerta;

    //Constructor
    public AlertaVencimiento(Prestamo prestamo, String tipoAlerta) {
        this.prestamo = prestamo;
        this.tipoAlerta = tipoAlerta;
    }

    public void mostrarAlerta() {
        System.out.println("ALERTA: " + tipoAlerta.toUpperCase());
        System.out.println("Recurso: " + prestamo.getRecurso().getIdentificador());
        System.out.println("Usuario: " + prestamo.getUsuario().getNombre());
        System.out.println("Fecha devolución esperada: " + prestamo.getFechaDevolucion());
        System.out.println("¿Desea renovar el prestamo?");
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
}
