package biblioteca;

public class AudioLibro extends RecursoDigitalBase implements Prestable {
    private String tiempo;

    public AudioLibro(String titulo, int id, String tiempo, ServicioNotificaciones servicioNotificaciones, CategoriaRecurso categoriaRecurso) {
        super(titulo, id, servicioNotificaciones, categoriaRecurso);
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
    public synchronized boolean estaDisponible() {
        return getEstado() == EstadoRecurso.DISPONIBLE;
    }

    @Override
    public synchronized void prestar(Usuario usuario) {
        System.out.println("[HILO " + Thread.currentThread().getName() + "] → Intentando prestar: " + getTitulo());
        if (!estaDisponible()) {
            System.out.println("[HILO " + Thread.currentThread().getName() + "] No disponible para préstamo.");
            throw new RecursoNoDisponibleException("No se puede prestar el AUDIO LIBRO: " + getTitulo() + " | No disponible");
        }

        actualizarEstado(EstadoRecurso.PRESTADO);
        System.out.println("[HILO " + Thread.currentThread().getName() + "] Préstamo exitoso de: " + getTitulo());

        if (servicioNotificaciones instanceof ServicioNotificacionesMail) {
            servicioNotificaciones.enviarNotificaciones("Se prestó el AudioLibro: " + getTitulo(), usuario.getMail());
        } else if (servicioNotificaciones instanceof ServicioNotificacionesSMS) {
            servicioNotificaciones.enviarNotificaciones("Se prestó el AudioLibro: " + getTitulo(), usuario.getTelefono());
        }
    }

    @Override
    public synchronized void devolver(Usuario usuario) {
        System.out.println("[HILO " + Thread.currentThread().getName() + "] → Intentando devolver: " + getTitulo());

        actualizarEstado(EstadoRecurso.DISPONIBLE);
        System.out.println("[HILO " + Thread.currentThread().getName() + "] Devolución exitosa de: " + getTitulo());

        if (servicioNotificaciones instanceof ServicioNotificacionesMail) {
            servicioNotificaciones.enviarNotificaciones("Se devolvió el AudioLibro: " + getTitulo(), usuario.getMail());
        } else if (servicioNotificaciones instanceof ServicioNotificacionesSMS) {
            servicioNotificaciones.enviarNotificaciones("Se devolvió el AudioLibro: " + getTitulo(), usuario.getTelefono());
        }

        notifyAll();
    }

}
