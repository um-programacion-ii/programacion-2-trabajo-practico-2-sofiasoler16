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

    @Override
    public String toString() {
        return super.toString() + " | Tiempo: " + tiempo;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(this.toString());
    }

}
