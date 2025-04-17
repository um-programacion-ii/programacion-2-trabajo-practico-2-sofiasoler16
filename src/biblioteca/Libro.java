package biblioteca;

public class Libro extends RecursoDigitalBase implements Renovable, Prestable {
    private String editorial;
    private String autor;
    private int ano;

    public Libro(String titulo, int id, String editorial, String autor, int ano, ServicioNotificaciones servicioNotificaciones, Categoria categoria) {
        super(titulo, id, servicioNotificaciones, categoria);
        this.editorial = editorial;
        this.autor = autor;
        this.ano = ano;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return super.toString() + " | Editorial: " + editorial + " | Autor: " + autor + " | Ano: " + ano;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println(this.toString());
    }

    @Override
    public boolean estaDisponible() {
        return true;
    }

    @Override
    public void prestar() {
        System.out.println("Libro prestado.");
        servicioNotificaciones.enviarNotificaciones("Se presto el libro: " + getTitulo());
    }

    @Override
    public void devolver() {
        System.out.println("Libro devuelto.");
        servicioNotificaciones.enviarNotificaciones("Se devolvio el libro: " + getTitulo());
    }

    @Override
    public void renovar() {
        System.out.println("Libro renovado.");
        servicioNotificaciones.enviarNotificaciones("Se renovo el libro: " + getTitulo());
    }

}
