package biblioteca;

import java.time.LocalDate;


public class Prestamo {
    private RecursoDigital recurso;
    private Usuario usuario;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    //Constructor
    public Prestamo(RecursoDigital recurso, Usuario usuario) {
        this.recurso = recurso;
        this.usuario = usuario;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucion = fechaPrestamo.plusDays(7);
    }

    public RecursoDigital getRecurso() {
        return recurso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion; }

    @Override
    public String toString() {
        return " Recurso: " + recurso.getIdentificador() +
                " Usuario: " + usuario.getNombre() + " " + usuario.getApellido() +
                " Prestado: " + fechaPrestamo +
                " Devolver antes de: " + fechaDevolucion;
    }

}
