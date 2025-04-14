package biblioteca;

public class usuario {
    private String nombre;
    private String apellido;
    private int id;
    private String mail;

    public usuario(String nombre, String apellido, int id, String mail) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.mail = mail;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
}
