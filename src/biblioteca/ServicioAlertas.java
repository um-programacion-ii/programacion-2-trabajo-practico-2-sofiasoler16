package biblioteca;

import java.time.LocalDate;

public class ServicioAlertas {
    private GestorBiblioteca gestor;

    //Constructor
    public ServicioAlertas(GestorBiblioteca gestor) {
        this.gestor = gestor;
    }

    public void verificarAlertasVencimiento() {
        LocalDate fechaActual = LocalDate.now();

        for (Prestamo prestamo : gestor.getPrestamos()) {
            LocalDate vencimiento = prestamo.getFechaDevolucion();
            if (vencimiento != null) {
                if (vencimiento.equals(fechaActual)) {
                    new AlertaVencimiento(prestamo, "Vencido").mostrarAlerta();
                } else if (vencimiento.minusDays(1).equals(fechaActual)) {
                    new AlertaVencimiento(prestamo, "Recordatorio").mostrarAlerta();
                }
            }
        }
    }
}
