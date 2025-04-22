package biblioteca;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Recordatorios {
    private final ServicioAlertas servicioAlertas;

    public Recordatorios(ServicioAlertas servicioAlertas) {
        this.servicioAlertas = servicioAlertas;
    }

    public void iniciar() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("🔄 Verificando alertas periódicamente...");
            List<AlertaVencimiento> alertas = servicioAlertas.obtenerAlertasPendientes();
            for (AlertaVencimiento alerta : alertas) {
                alerta.mostrarAlerta();
            }
        }, 0, 10, TimeUnit.SECONDS); // cada 10 segundos
    }

}
