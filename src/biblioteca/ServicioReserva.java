package biblioteca;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServicioReserva {
    private BlockingQueue<Reserva> colaReservas;

    public ServicioReserva() {
        this.colaReservas = new LinkedBlockingQueue<>();
    }

    public void agregarReserva(Reserva reserva){
        try {
            colaReservas.put(reserva);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Error al agregar reserva ");
        }
    }

}
