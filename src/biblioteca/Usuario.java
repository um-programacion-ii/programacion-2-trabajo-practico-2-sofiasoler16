package biblioteca;

public class Usuario {
    private String nombre;
    private String apellido;
    private int id;
    private String mail;
    private String telefono;

    public Usuario(String nombre, String apellido, int id, String mail, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.mail = mail;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
