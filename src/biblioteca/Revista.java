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
    public boolean estaDisponible() {
        return getEstado() == EstadoRecurso.DISPONIBLE;
    }

    @Override
    public void prestar() {
        if (!estaDisponible()) {
            throw new RecursoNoDisponibleException("No se puede prestar la REVISTA " + getTitulo() + " No disponible");
        }
        actualizarEstado(EstadoRecurso.PRESTADO);

        System.out.println("Revista prestado.");
        servicioNotificaciones.enviarNotificaciones("Se presto la revista: " + getTitulo());
    }

    @Override
    public void devolver() {
        actualizarEstado(EstadoRecurso.DISPONIBLE);
        System.out.println("Revista devuelto.");
        servicioNotificaciones.enviarNotificaciones("Se devolvio la revista: " + getTitulo());
    }

    @Override
    public void renovar() {
        System.out.println("Revista renovado.");
        servicioNotificaciones.enviarNotificaciones(("Se renovo la revista: " + getTitulo()));
    }

}
