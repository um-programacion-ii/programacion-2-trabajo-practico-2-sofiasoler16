package biblioteca;

public interface RecursoDigital {
    String getIdentificador();
    void mostrarInformacion();
    CategoriaRecurso getCategoria();
    EstadoRecurso getEstado();
    void actualizarEstado(EstadoRecurso estado);
}
