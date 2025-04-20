package biblioteca;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServicioNotificacionesSMS implements ServicioNotificaciones {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void enviarNotificaciones(String mensaje) {
        NotificacionesSMS notificacion = new NotificacionesSMS(mensaje, "+549261000000"); // o número dinámico si querés
        executor.execute(notificacion::enviar);
    }

    public void cerrar() {
        executor.shutdown();
    }
}
