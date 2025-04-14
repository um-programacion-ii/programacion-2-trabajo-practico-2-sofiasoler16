package biblioteca;

public abstract class recursoDigitalBase {
    private String titulo;
    private int id;

    public recursoDigitalBase(String titulo, int id) {
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
