package componentes;

import bus.EventHandler;
import eventos.BandaTocandoEvent;

/**
 * Ajusta el sonido cuando la banda toca.
 */
public class SistemaDeSonido implements EventHandler<BandaTocandoEvent> {

    @Override
    public void handle(BandaTocandoEvent event) {
        System.out.println("[Sonido] Ajustando para: " + event.getCancion());
    }
}