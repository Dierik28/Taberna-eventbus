package componentes;

import bus.EventHandler;
import eventos.BandaTocandoEvent;

/**
 * Activa efectos especiales en ciertas canciones.
 */
public class SistemaDeHumo implements EventHandler<BandaTocandoEvent> {

    @Override
    public void handle(BandaTocandoEvent event) {

        if (event.getCancion().equalsIgnoreCase("Oye Mi Amor")) {
            System.out.println("[Humo] Se activan efectos especiales");
        }
    }
}