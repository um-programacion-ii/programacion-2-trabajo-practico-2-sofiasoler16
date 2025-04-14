package biblioteca;

public class Revista extends RecursoDigitalBase {
    private int numeroEdicion;

    public Revista(String titulo, int id, int numeroEdicion) {
        super(titulo, id);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }
}
