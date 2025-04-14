package biblioteca;

public class audioLibro extends recursoDigitalBase{
    private String tiempo;

    public audioLibro(String titulo, int id, String tiempo) {
        super(titulo, id);
        this.tiempo = tiempo;
    }

    public String getTiempo() {
        return tiempo;
    }
}
