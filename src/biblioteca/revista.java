package biblioteca;

public class revista extends recursoDigitalBase{
    private int numeroEdicion;

    public revista(String titulo, int id, int numeroEdicion) {
        super(titulo, id);
        this.numeroEdicion = numeroEdicion;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }
}
