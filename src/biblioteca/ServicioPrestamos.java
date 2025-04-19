package biblioteca;

import java.util.List;

public class ServicioPrestamos {
    private GestorBiblioteca gestor;

    public ServicioPrestamos(GestorBiblioteca gestor) {
        this.gestor = gestor;
    }

    public void prestar(RecursoDigital recurso, Usuario usuario) {
        try {
            if (!(recurso instanceof Prestable)) {
                System.out.println("Este recurso no se puede prestar");
                return;
            }

            ((Prestable) recurso).prestar(); // esto ya lanza excepción si está prestado

            recurso.actualizarEstado(EstadoRecurso.PRESTADO);

            Prestamo prestamo = new Prestamo(recurso, usuario);
            gestor.agregarPrestamo(prestamo);

            System.out.println("Préstamo exitoso: " + prestamo);
        } catch (RecursoNoDisponibleException e) {
            System.out.println( e.getMessage());
        }
    }

    public void devolver(RecursoDigital recurso) {
        if (!(recurso instanceof Prestable)) {
            System.out.println("❌ Este recurso no se puede devolver.");
            return;
        }

        ((Prestable) recurso).devolver();
        recurso.actualizarEstado(EstadoRecurso.DISPONIBLE);

        System.out.println("Devolucion exitosa");
    }

    public void agregarPrestamo(String titulo, String idUsuario) {
        List<RecursoDigital> encontrados = gestor.buscarPorTitulo(titulo);

        if (encontrados.isEmpty()) {
            throw new RecursoNoDisponibleException("Recurso no encontrado.");
        }

        RecursoDigital recurso = encontrados.get(0);

        Usuario usuario = gestor.buscarUsuarioPorId(idUsuario);

        prestar(recurso, usuario);
    }

}
