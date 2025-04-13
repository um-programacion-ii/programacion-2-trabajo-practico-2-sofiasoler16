package biblioteca;

import java.util.ArrayList;
import java.util.List;

//Con gestorUsuarios recorremos los usuarios que hay en una lista y los agregamos a ella

public class gestorUsuarios {
    private List<usuario> usuarios;

    public gestorUsuarios() {
        usuarios = new ArrayList<>();
    }

    public void agregarUsuario(usuario usuario) {
        usuarios.add(usuario);
    }

    public List<usuario> getUsuarios() {
        return usuarios;
    }
    
}
