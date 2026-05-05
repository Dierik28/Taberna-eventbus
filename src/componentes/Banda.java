package componentes;

import bus.EventBus;
import eventos.BandaTocandoEvent;

/**
 * Publica eventos cuando toca música.
 */
public class Banda {

    private final EventBus bus;

    public Banda(EventBus bus) {
        this.bus = bus;
    }

    public void tocarCancion(String banda, String cancion, int duracion) {

        System.out.println("\n[Banda] Tocando: " + cancion);

        bus.publicar(new BandaTocandoEvent(banda, cancion, duracion));
    }
}