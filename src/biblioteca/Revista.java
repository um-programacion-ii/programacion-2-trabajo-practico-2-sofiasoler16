package biblioteca;

public class Revista extends RecursoDigitalBase implements Renovable, Prestable {
    private int numeroEdicion;

    public Revista(String titulo, int id, int numeroEdicion, ServicioNotificaciones servicioNotificaciones, CategoriaRecurso categoriaRecurso) {
        super(titulo, id, servicioNotificaciones, categoriaRecurso);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    @Override
    public String toString() {
        return super.toString() + " | Nº edición: " + numeroEdicion;
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
        if (!estaDisponible()) {
            throw new RecursoNoDisponibleException("No se puede prestar la REVISTA " + getTitulo() + " No disponible");
        }
        actualizarEstado(EstadoRecurso.PRESTADO);
        System.out.println("Revista prestado.");

        if (servicioNotificaciones instanceof ServicioNotificacionesMail) {
            servicioNotificaciones.enviarNotificaciones("Se presto la revista: " + getTitulo(), usuario.getMail());
        } else if (servicioNotificaciones instanceof ServicioNotificacionesSMS) {
            servicioNotificaciones.enviarNotificaciones("Se presto la revista: " + getTitulo(), usuario.getTelefono());
        }

    }

    @Override
    public synchronized void devolver(Usuario usuario) {
        actualizarEstado(EstadoRecurso.DISPONIBLE);
        System.out.println("Revista devuelto.");

        if (servicioNotificaciones instanceof ServicioNotificacionesMail) {
            servicioNotificaciones.enviarNotificaciones("Se devolvió la revista: " + getTitulo(), usuario.getMail());
        } else if (servicioNotificaciones instanceof ServicioNotificacionesSMS) {
            servicioNotificaciones.enviarNotificaciones("Se devolvió la revista: " + getTitulo(), usuario.getTelefono());
        }

    }

    @Override
    public void renovar(Usuario usuario) {
        System.out.println("Revista renovado.");

        if (servicioNotificaciones instanceof ServicioNotificacionesMail) {
            servicioNotificaciones.enviarNotificaciones("Se renovo la revista: " + getTitulo(), usuario.getMail());
        } else if (servicioNotificaciones instanceof ServicioNotificacionesSMS) {
            servicioNotificaciones.enviarNotificaciones("Se renovo la revista: " + getTitulo(), usuario.getTelefono());
        }

    }

}
