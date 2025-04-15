package biblioteca;

public class ServicioNotificacionesSMS implements ServicioNotificaciones {
    @Override
    public void enviarNotificaciones(String mensaje) {
        System.out.println("Enviar mensaje" + mensaje);
    }

}
