package biblioteca;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Recordatorios {
    private final ServicioAlertas servicioAlertas;
    private final HistorialAlertas historialAlertas;
    private final ScheduledExecutorService scheduler;

    public Recordatorios(ServicioAlertas servicioAlertas, HistorialAlertas historialAlertas) {
        this.servicioAlertas = servicioAlertas;
        this.historialAlertas = historialAlertas;
        this.scheduler = Executors.newScheduledThreadPool(3);
    }

    public void iniciar() {
        // ERROR → cada 10 segundos
        scheduler.scheduleAtFixedRate(() -> {
            mostrarAlertasPorNivel(NivelUrgencia.ERROR);
        }, 0, 10, TimeUnit.SECONDS);

        // WARNING → cada 20 segundos
        scheduler.scheduleAtFixedRate(() -> {
            mostrarAlertasPorNivel(NivelUrgencia.WARNING);
        }, 0, 20, TimeUnit.SECONDS);

        // INFO → cada 30 segundos
        scheduler.scheduleAtFixedRate(() -> {
            mostrarAlertasPorNivel(NivelUrgencia.INFO);
        }, 0, 30, TimeUnit.SECONDS);
    }
    private void mostrarAlertasPorNivel(NivelUrgencia nivel) {
        System.out.println("🔄 Verificando alertas [" + nivel + "]...");
        List<AlertaVencimiento> alertas = servicioAlertas.obtenerAlertasPendientes();

        for (AlertaVencimiento alerta : alertas) {
            if (alerta.getNivelUrgencia() == nivel) {
                alerta.mostrarAlerta();
                historialAlertas.registrarAlerta("[" + nivel + "] " + alerta.getPrestamo().getRecurso().getIdentificador());
            }
        }
    }

}
