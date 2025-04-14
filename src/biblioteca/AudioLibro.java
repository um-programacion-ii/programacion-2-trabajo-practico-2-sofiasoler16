package biblioteca;

public class AudioLibro extends RecursoDigitalBase {
    private String tiempo;

    public AudioLibro(String titulo, int id, String tiempo) {
        super(titulo, id);
        this.tiempo = tiempo;
    }

    public String getTiempo() {
        return tiempo;
    }
}
