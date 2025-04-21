package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicioAlertas {
    private GestorBiblioteca gestor;

    //Constructor
    public ServicioAlertas(GestorBiblioteca gestor) {
        this.gestor = gestor;
    }

    public List<AlertaVencimiento> obtenerAlertasPendientes(){
        LocalDate fechaActual = LocalDate.now();
        List<AlertaVencimiento> alertas = new ArrayList<>();

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
        return alertas;
    }

    public List<AlertaVencimiento> obtenerAlertasPorUsuario(Usuario usuario) {
        return gestor.getPrestamos().stream()
                .filter(p -> p.getUsuario().getId() == usuario.getId())
                .map(p -> new AlertaVencimiento(p, "Vencido"))
                .toList();
    }

}
