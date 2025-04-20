package biblioteca;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServicioNotificacionesMail implements ServicioNotificaciones {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void enviarNotificaciones(String mensaje, String destinatario) {
        NotificacionesMail notificacion = new NotificacionesMail(mensaje, destinatario);
        executor.execute(notificacion::enviar);
    }

    public void cerrar() {
        executor.shutdown();
    }
}
