package biblioteca;

public class NotificacionesMail extends Notificaciones {
    private String destinatarioMail;

    public NotificacionesMail(String mensaje, String destinatario) {
        super(mensaje);
        this.destinatarioMail = destinatario;
    }

    @Override
    public void enviar() {
        System.out.println("Email a " + destinatarioMail + ": " + mensaje);
    }
}
