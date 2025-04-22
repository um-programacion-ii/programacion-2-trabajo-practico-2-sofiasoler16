package biblioteca;

public class ServicioNotificadorPreferencia {
    public static void notificar(String mensaje, Usuario usuario) {
        if (usuario.getTipoNotificacion() == TipoNotificacion.EMAIL) {
            Notificaciones noti = new NotificacionesMail(mensaje, usuario.getMail());
            noti.enviar();
        } else if (usuario.getTipoNotificacion() == TipoNotificacion.SMS) {
            Notificaciones noti = new NotificacionesSMS(mensaje, usuario.getTelefono());
            noti.enviar();
        }
    }
}
