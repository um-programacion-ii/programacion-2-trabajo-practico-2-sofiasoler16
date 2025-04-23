package biblioteca;

public class Podcast extends RecursoDigitalBase implements Prestable{
    private String canal;

    public Podcast(String titulo, int id, String canal, CategoriaRecurso categoriaRecurso) {
        super(titulo, id, categoriaRecurso);
        this.canal = canal;
    }

    public String getCanal() {
        return canal;
    }

    @Override
    public String toString() {
        return super.toString() + " | Canal: " + canal;
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
            throw new RecursoNoDisponibleException("No se puede prestar el PODCAST " + getTitulo() + " No disponible");
        }
        actualizarEstado(EstadoRecurso.PRESTADO);
        System.out.println("[HILO " + Thread.currentThread().getName() + "] Préstamo exitoso de: " + getTitulo());

        ServicioNotificadorPreferencia.notificar("Se prestó el Podcast: " + getTitulo(), usuario);

    }

    @Override
    public synchronized void devolver(Usuario usuario) {
        System.out.println("[HILO " + Thread.currentThread().getName() + "] Préstamo exitoso de: " + getTitulo());

        actualizarEstado(EstadoRecurso.DISPONIBLE);
        System.out.println("[HILO " + Thread.currentThread().getName() + "] Devolución exitosa de: " + getTitulo());

        ServicioNotificadorPreferencia.notificar("Se devolvio el Podcast: " + getTitulo(), usuario);
    }

}
