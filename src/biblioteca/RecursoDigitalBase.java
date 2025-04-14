package biblioteca;

public abstract class RecursoDigitalBase {
    private String titulo;
    private int id;

    public RecursoDigitalBase(String titulo, int id) {
        this.titulo = titulo;
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

}
