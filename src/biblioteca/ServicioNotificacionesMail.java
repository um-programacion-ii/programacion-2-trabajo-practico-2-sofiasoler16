package biblioteca;

public class ServicioNotificacionesMail implements ServicioNotificaciones {
    @Override
    public void enviarNotificaciones(String mensaje) {
        System.out.println("Enviar mail" + mensaje);
    }
}
