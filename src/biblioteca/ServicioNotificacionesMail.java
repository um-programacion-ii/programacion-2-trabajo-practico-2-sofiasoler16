package biblioteca;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServicioNotificacionesMail implements ServicioNotificaciones {
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    public void enviarNotificaciones(String mensaje) {
        NotificacionesMail notificacion = new NotificacionesMail(mensaje, "sofi@mail.com");
        executor.execute(notificacion::enviar);
    }

    public void cerrar() {
        executor.shutdown();
    }
}
