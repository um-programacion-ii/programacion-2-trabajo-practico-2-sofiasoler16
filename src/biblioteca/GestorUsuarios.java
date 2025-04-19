package biblioteca;

import java.util.ArrayList;
import java.util.List;

//Con gestorUsuarios recorremos los usuarios que hay en una lista y los agregamos a ella

public class GestorUsuarios {
    private List<Usuario> Usuarios;

    public GestorUsuarios() {
        Usuarios = new ArrayList<>();
    }

    public void agregarUsuario(Usuario Usuario) {
        Usuarios.add(Usuario);
    }

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }

}
