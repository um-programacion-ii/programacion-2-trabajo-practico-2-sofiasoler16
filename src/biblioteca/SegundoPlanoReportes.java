package biblioteca;

public class SegundoPlanoReportes implements Runnable{
    private final ServicioReportes servicioReportes;
    private final String tipo;

    public SegundoPlanoReportes(ServicioReportes servicioReportes, String tipo) {
        this.servicioReportes = servicioReportes;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        System.out.println("🔍 Generando reporte: " + tipo + "...");
        try {
            Thread.sleep(3000); // Simula procesamiento
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        switch (tipo) {
            case "prestamos":
                servicioReportes.reporteRecursosMasPrestados(5);
                break;
            case "usuarios":
                servicioReportes.reporteUsuariosMasActivos(5);
                break;
            case "categorias":
                servicioReportes.reporteEstadisticasPorCategoria();
                break;
            default:
                System.out.println("Tipo de reporte desconocido.");
        }

        System.out.println("✅ Reporte " + tipo + " generado.");
    }

}
