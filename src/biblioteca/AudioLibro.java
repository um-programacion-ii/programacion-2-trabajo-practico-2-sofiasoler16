package biblioteca;

public class AudioLibro extends RecursoDigitalBase implements Prestable {
    private String tiempo;

    public AudioLibro(String titulo, int id, String tiempo, ServicioNotificaciones servicioNotificaciones, Categoria categoria) {
        super(titulo, id, servicioNotificaciones, categoria);
        this.tiempo = tiempo;
    }

    public String getTiempo() {
        return tiempo;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tiempo: " + tiempo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(this.toString());
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }

    @Override
    public void prestar() {
        System.out.println("AudioLibro prestado.");
        servicioNotificaciones.enviarNotificaciones("Se presto el AudioLibro: " + getTitulo());
    }

    @Override
    public void devolver() {
        System.out.println("AudioLibro devuelto.");
        servicioNotificaciones.enviarNotificaciones("Se devolvio el AudioLibro: " + getTitulo());
    }

}
