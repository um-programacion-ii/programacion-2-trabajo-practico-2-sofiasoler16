package biblioteca;

public class Podcast extends RecursoDigitalBase {
    private String canal;

    public Podcast(String titulo, int id, String canal) {
        super(titulo, id);
        this.canal = canal;
    }

    public String getCanal() {
        return canal;
    }

    @Override
    public String toString() {
        return super.toString() + " | Canal: " + canal;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(this.toString());
    }

}
