package biblioteca;

public abstract class RecursoDigitalBase implements RecursoDigital{
    private String titulo;
    private int id;
    protected ServicioNotificaciones servicioNotificaciones;
    private CategoriaRecurso categoriaRecurso;

    public RecursoDigitalBase(String titulo, int id, ServicioNotificaciones servicioNotificaciones, CategoriaRecurso categoriaRecurso) {
        this.titulo = titulo;
        this.id = id;
        this.servicioNotificaciones = servicioNotificaciones;
        this.categoriaRecurso = categoriaRecurso;
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

    @Override
    public String toString() {
        return "Título: " + titulo + " | ID: " + id;
    }

    @Override
    public String getIdentificador() {
        return titulo;
    }


    public void mostrarInformacion() {
        System.out.println(this.toString());
    }

    public CategoriaRecurso getCategoria() {
        return categoriaRecurso;
    }

}
