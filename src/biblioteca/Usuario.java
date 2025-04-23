package biblioteca;

public class Usuario {
    private String nombre;
    private String apellido;
    private int id;
    private String mail;
    private String telefono;
    private TipoNotificacion tipoNotificacion;
    private NivelUrgencia nivelMinimoUrgencia;

    public Usuario(String nombre, String apellido, int id, String mail, String telefono, TipoNotificacion tipoNotificacion, NivelUrgencia nivelMinimoUrgencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.mail = mail;
        this.telefono = telefono;
        this.tipoNotificacion = tipoNotificacion;
        this.nivelMinimoUrgencia = nivelMinimoUrgencia;
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

    public TipoNotificacion getTipoNotificacion() {
        return tipoNotificacion;
    }

    public NivelUrgencia getNivelMinimoUrgencia() {
        return nivelMinimoUrgencia;
    }

    public boolean deseaNotificar(NivelUrgencia urgencia) {
        return urgencia.ordinal() >= nivelMinimoUrgencia.ordinal();
    }
}
