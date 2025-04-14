package biblioteca;

public abstract class recursoDigital {
    private String titulo;
    private int id;

    public recursoDigital(String titulo, int id) {
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
