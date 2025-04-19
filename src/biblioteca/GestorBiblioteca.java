package biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GestorBiblioteca {
    private List<RecursoDigital> recursos;
    private Map<String, Usuario> usuarios;
    private List<Prestamo> prestamos = new ArrayList<>();

    public GestorBiblioteca() {
        recursos = new ArrayList<>();
        usuarios = new HashMap<>();
    }

    public void agregarRecurso(RecursoDigital recurso) {
        recursos.add(recurso);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(String.valueOf(usuario.getId()), usuario);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public RecursoDigital buscarRecursoPorTitulo(String titulo) {
        for (RecursoDigital recurso : recursos) {
            if (recurso.getIdentificador().equalsIgnoreCase(titulo)) {
                return recurso;
            }
        }
        return null;
    }

    //Devuelve un usuario del Map
    public Usuario buscarUsuarioPorId(String id) throws UsuarioNoEncontradoException {
        Usuario usuario = usuarios.get(String.valueOf(id));
        if (usuario == null) {
            throw new UsuarioNoEncontradoException("Usuario no encontrado");
        }
        return usuario;
    }

    //Devuelve lista filtrada de recursos
    public List<RecursoDigital> buscarPorTitulo(String titulo) {
        return recursos.stream()
                .filter(r -> r.getIdentificador().toLowerCase().contains(titulo.toLowerCase()))
                .toList();
    }

    //Devuelve lista de recursos
    public List<RecursoDigital> getRecursos() {
        return recursos;
    }

    //Mapear entre usuarios
    public Map<String, Usuario> getUsuarios() {
        return usuarios;
    }

    //Devuelve prestamos
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    //Devuelve el recurso filtrado por categoria
    public List<RecursoDigital> filtrarPorCategoria(CategoriaRecurso categoriaRecurso) {
        return recursos.stream()
                .filter(r -> r.getCategoria() == categoriaRecurso)
                .toList();
    }

}